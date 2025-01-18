package hackerRank;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.List;
import java.util.stream.Stream;

//        Birthday Cake Candles
//        https://www.hackerrank.com/challenges/birthday-cake-candles/problem?isFullScreen=true
import static java.util.stream.Collectors.toList;

public class BirthdayCakeCandlesCalculation {

    public static void main(String[] args) throws IOException {

        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        List<Integer> arr = Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
                .map(Integer::parseInt)
                .collect(toList());
        int result = BirthdayCakeCandlesCalculation.birthdayCakeCandles(arr);

        bufferedReader.close();
    }

    public static int birthdayCakeCandles(List<Integer> candles) {
        // Step 1: Find the tallest candle (maximum height)
        int tallest = Collections.max(candles);
        System.out.println(tallest);
        // Step 2: Count how many times the tallest height appears in the list
        int count = 0;
        for (int height : candles) {
            if (height == tallest) {
                count++;
            }
        }
        // Step 3: Return the count of the tallest candles
        return count;
    }

}