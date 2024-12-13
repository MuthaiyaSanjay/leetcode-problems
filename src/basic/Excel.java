package basic;

import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;

import java.io.*;
import java.util.*;

public class Excel {

    public static void main(String[] args) {

        File excelFile = new File("D:\\test.xlsx");
        List<Map<String, Object>> jsonResult = new ArrayList<>();

        Map<String, Object> currentChapter = null;
        Map<String, Object> currentHeading = null;
        Map<String, Object> currentSubHeading = null;
        String desValues = "";

        try (FileInputStream fis = new FileInputStream(excelFile)) {
            Workbook workbook = new XSSFWorkbook(fis);
            Sheet sheet = workbook.getSheetAt(0); // Assuming the data is in the first sheet

            for (Row row : sheet) {
                if (row.getRowNum() == 0) continue; // Skip header row

                // Getting the cell values
                Cell treeLevelCell = row.getCell(2); // 3rd column: treeLevel
                Cell hsCodeCell = row.getCell(3); // 4th column: HSCode
                Cell descriptionCell = row.getCell(4); // 5th column: Description

                // If HSCode or Description is empty, break the loop
                if (getCellValueAsString(hsCodeCell).isEmpty() || getCellValueAsString(descriptionCell).isEmpty()) {
                    break; // Break the loop if there is an empty cell in the HSCode or Description
                }

                // Parsing cell values
                int treeLevel = (int) getCellValueAsNumeric(treeLevelCell);
                String hsCode = getCellValueAsString(hsCodeCell);
                String description = getCellValueAsString(descriptionCell);

                // Check for new chapter (starts with HSCode "01", "02", etc.)
                if (treeLevel == 0) { // New chapter
                    currentChapter = new HashMap<>();
                    currentChapter.put("chapterId", UUID.randomUUID().toString());
                    currentChapter.put("title", description.replaceAll("-+", ""));
                    currentChapter.put("chapterHSCode", hsCode);
                    currentChapter.put("organization", "WCO");
                    currentChapter.put("classification", "CHAPTER");
                    currentChapter.put("description", Arrays.asList(description));
                    currentChapter.put("headings", new ArrayList<>());
                    jsonResult.add(currentChapter);
                    currentHeading = null;
                    currentSubHeading = null;
                } else if (treeLevel == 1 && currentChapter != null) { // New heading
                    currentHeading = new HashMap<>();
                    currentHeading.put("headingId", UUID.randomUUID().toString());
                    currentHeading.put("title", description.replaceAll("-+", ""));
                    currentHeading.put("headingHSCode", hsCode);
                    currentHeading.put("organization", "WCO");
                    currentHeading.put("classification", "HEADING");
                    currentHeading.put("description", Arrays.asList(description));
                    currentHeading.put("subHeadings", new ArrayList<>());
                    List<Map<String, Object>> headings = (List<Map<String, Object>>) currentChapter.get("headings");
                    headings.add(currentHeading);
                    currentSubHeading = null;
                } else if (treeLevel == 2 && currentHeading != null && hsCode.length() == 5) { // Subheading level
                    desValues = description.replaceAll("-+", "");
                } else if (treeLevel == 2 && currentHeading != null && hsCode.length() == 6 || treeLevel == 3 && currentHeading != null && hsCode.length() == 6) { // New subheading
                    currentSubHeading = new HashMap<>();
                    currentSubHeading.put("subHeadingId", UUID.randomUUID().toString());
                    currentSubHeading.put("title", description.replaceAll("-+", ""));
                    currentSubHeading.put("subHeadingHSCode", hsCode);
                    currentSubHeading.put("organization", "WCO");
                    currentSubHeading.put("classification", "SUB_HEADING");
                    boolean val = checkIfence(description);
                    if (val) {
                        String val1 = desValues + description.replaceAll("-+", "");
                        currentSubHeading.put("description", Arrays.asList(val1));
                    } else {
                        currentSubHeading.put("description", new ArrayList<>());
                    }
                    currentSubHeading.put("tariffItems", new ArrayList<>());
                    List<Map<String, Object>> subHeadings = (List<Map<String, Object>>) currentHeading.get("subHeadings");
                    subHeadings.add(currentSubHeading);
                } else if (treeLevel == 3 && currentSubHeading != null && hsCode.length() == 6) { // Tariff item level
                    Map<String, Object> tariffItem = new HashMap<>();
                    tariffItem.put("tariffItemId", UUID.randomUUID().toString());
                    tariffItem.put("tariffItemHSCode", hsCode);
                    tariffItem.put("title", description.replaceAll("-+", ""));
                    tariffItem.put("organization", "IN");
                    tariffItem.put("classification", "TARIFF_ITEM");
                    tariffItem.put("description", new ArrayList<>());
                    List<Map<String, Object>> tariffItems = (List<Map<String, Object>>) currentSubHeading.get("tariffItems");
                    tariffItems.add(tariffItem);
                }
            }

            // Convert the result to JSON format
            ObjectMapper objectMapper = new ObjectMapper();
            objectMapper.enable(SerializationFeature.INDENT_OUTPUT);
            String jsonOutput = objectMapper.writeValueAsString(jsonResult);
            int total = getTotalChaptersCount();
            String indexValues = getChapterAtIndex(0);
            System.out.println(indexValues);
            System.out.println("Total counts : " + total);
            File outputFile = new File("D:\\output.json"); // Specify your desired .json file path
            try (BufferedWriter writer = new BufferedWriter(new FileWriter(outputFile))) {
                writer.write(jsonOutput); // Write JSON output to the file
            } catch (IOException e) {
                e.printStackTrace();
            }

            System.out.println(jsonOutput);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static int getTotalChaptersCount() {
        // Define the path to the JSON file
        File jsonFile = new File("D:\\output.json");
        int totalChapters = 0;

        try {
            // Initialize ObjectMapper to read JSON
            ObjectMapper objectMapper = new ObjectMapper();

            // Read the JSON file into a list of maps (each representing a chapter)
            List<Map<String, Object>> jsonResult = objectMapper.readValue(jsonFile, List.class);

            // Get the total number of chapters
            totalChapters = jsonResult.size();
            System.out.println("Total Chapters: " + totalChapters);

        } catch (IOException e) {
            e.printStackTrace();
        }

        return totalChapters;
    }

    public static String getChapterAtIndex(int index) {
        File jsonFile = new File("D:\\output.json");
        String chapterJson = null;

        try {
            ObjectMapper objectMapper = new ObjectMapper();
            // Read the JSON file into a list of maps (each representing a chapter)
            List<Map<String, Object>> jsonResult = objectMapper.readValue(jsonFile, List.class);

            // Check if the index is valid
            if (index >= 0 && index < jsonResult.size()) {
                Map<String, Object> chapter = jsonResult.get(index);

                // Convert the chapter map back into a JSON string
                chapterJson = objectMapper.writeValueAsString(chapter);
            } else {
                System.out.println("Invalid index: " + index);
            }

        } catch (IOException e) {
            e.printStackTrace();
        }

        return chapterJson;
    }


    // Utility method to handle numeric cell values safely
    private static double getCellValueAsNumeric(Cell cell) {
        if (cell == null) return 0;
        if (cell.getCellType() == CellType.NUMERIC) {
            return cell.getNumericCellValue();
        } else if (cell.getCellType() == CellType.STRING) {
            try {
                return Double.parseDouble(cell.getStringCellValue().trim());
            } catch (NumberFormatException e) {
                return 0;
            }
        }
        return 0;
    }

    // Utility method to handle string cell values safely
    private static String getCellValueAsString(Cell cell) {
        if (cell == null) return "";
        if (cell.getCellType() == CellType.STRING) {
            return cell.getStringCellValue().trim();
        } else if (cell.getCellType() == CellType.NUMERIC) {
            return String.valueOf((int) cell.getNumericCellValue());
        }
        return "";
    }

    public static boolean checkIfence(String input) {
        int dashCount = 0;
        for (int i = 0; i < 7; i++) {
            if (input.charAt(i) == '-') {
                dashCount++;
            }
        }
        return dashCount == 3;
    }
}
