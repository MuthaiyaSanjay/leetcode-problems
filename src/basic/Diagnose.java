package basic;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;
import java.util.stream.Stream;

import static java.util.stream.Collectors.toList;

public class Diagnose {


    public static int diagonalDifference(List<List<Integer>> arr) {
        int primaryDiagonalSum = 0;
        int secondaryDiagonalSum = 0;

        for (int i = 0; i < arr.size(); i++) {
            primaryDiagonalSum += arr.get(i).get(i);
            secondaryDiagonalSum += arr.get(i).get(arr.size() - 1 - i);
        }
        return Math.abs(primaryDiagonalSum - secondaryDiagonalSum);
    }

//        Sample output input and output
//        3
//        1 2 3
//        4 5 6
//        9 8 9

    public static void main(String[] args) throws IOException {

        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));
        int n = Integer.parseInt(bufferedReader.readLine().trim());
        List<List<Integer>> arr = new ArrayList<>();
        IntStream.range(0, n).forEach(i -> {
            try {
                arr.add(
                        Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
                                .map(Integer::parseInt)
                                .collect(toList())
                );
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        });

        int result = Diagnose.diagonalDifference(arr);
        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();
        bufferedReader.close();
        bufferedWriter.close();
    }

}
