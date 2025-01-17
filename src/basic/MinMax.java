package basic;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Stream;

import static java.util.stream.Collectors.toList;

//  HackerRank Problem:
//  https://www.hackerrank.com/challenges/mini-max-sum/problem?isFullScreen=true

public class MinMax {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        List<Integer> arr = Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
                .map(Integer::parseInt)
                .collect(toList());
        MinMax.minMax(arr);

        bufferedReader.close();
    }

    private static void minMax(List<Integer> arr) {
        Collections.sort(arr);

        // Calculate the sum of all elements
        long totalSum = 0;
        for (int num : arr) {
            totalSum += num;
        }

        // The minimum sum is the total sum minus the largest element
        long minSum = totalSum - arr.get(arr.size() - 1);

        // The maximum sum is the total sum minus the smallest element
        long maxSum = totalSum - arr.get(0);

        // Print the result
        System.out.println(minSum + " " + maxSum);

    }
}
