package basic;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
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

        MinMax.approach1(arr);
        MinMax.approach2(arr);

        bufferedReader.close();
    }


    private static void approach1(List<Integer> arr) {
        int[] sum = new int[arr.size()];
        for (int i = 0; i < arr.size(); i++) {
            int add = 0;
            for (int j = 0; j < arr.size(); j++) {
                if (i == j) {
                    continue;
                }
                add += arr.get(j);
            }
            System.out.println("add :: " + add);
            sum[i] = add;
        }
        Arrays.sort(sum);
        System.out.print(sum[sum.length - 1] + " " + sum[0]);
    }


    private static void approach2(List<Integer> arr) {
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
