package hackerRank;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.List;
import java.util.stream.Stream;

import static java.util.stream.Collectors.toList;

// HackerRank Link
//https://www.hackerrank.com/challenges/plus-minus/problem?isFullScreen=true
// Sample Input and Output
//         6
//        -4 3 -9 0 4 1
//
//        0.500000
//        0.333333
//        0.166667

public class PlusMinus {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(bufferedReader.readLine().trim());
        List<Integer> arr = Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
                .map(Integer::parseInt)
                .collect(toList());
        PlusMinus.plusMinus(arr);
        bufferedReader.close();
    }

    private static void plusMinus(List<Integer> arr) {
        int plus = 0;
        int minus = 0;
        int zero = 0;
        for (int val : arr) {
            if (val == 0) {
                zero++;
            } else if (val > 0) {
                plus++;
            } else {
                minus++;
            }
        }
        System.out.printf("%.6f%n", (float) plus / arr.size());
        System.out.printf("%.6f%n", (float) minus / arr.size());
        System.out.printf("%.6f%n", (float) zero / arr.size());
    }
}
