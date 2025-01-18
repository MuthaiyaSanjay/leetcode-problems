package hackerRank;

import java.util.Arrays;

public class ReverseArray {
    public static void main(String[] args) {

        int[] arr = {1, 5, 2, 3, 4, 5};

        for (int i = 0; i < arr.length / 2; i++) {
            int t = arr[i];
            System.out.println(t + " t values");
            arr[i] = arr[arr.length - 1 - i];
            arr[arr.length - 1 - i] = t;
        }

        System.out.println("" + Arrays.toString(arr));
    }
}
