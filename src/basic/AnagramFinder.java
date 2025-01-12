package basic;

import java.util.*;


public class AnagramFinder {
    public static String sortString(String str) {
        char[] charArray = str.toCharArray();
        Arrays.sort(charArray);
        return new String(charArray);
    }
    public static void findAnagrams(String paragraph) {
        String[] words = paragraph.split("\\s+");
        Map<String, Set<String>> anagramMap = new HashMap<>();
        for (String word : words) {
            String normalizedWord = word.toLowerCase().replaceAll("[^a-z]", "");
            System.out.println(normalizedWord);
            if (normalizedWord.isEmpty()) {
                continue;
            }
            String sortedWord = sortString(normalizedWord);
            anagramMap.putIfAbsent(sortedWord, new HashSet<>());
            anagramMap.get(sortedWord).add(normalizedWord);
        }
        for (Set<String> anagramGroup : anagramMap.values()) {
            if (anagramGroup.size() > 1) {
                System.out.println("Anagram group: " + anagramGroup);
            }
        }
    }

    public static void main(String[] args) {
        String paragraph = "Listen to the silent students. They are studying the same materials. "
                + "The students are eager to learn and engage in activities.";
        findAnagrams(paragraph);
    }
}

