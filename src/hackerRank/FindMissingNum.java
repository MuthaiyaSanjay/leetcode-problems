package hackerRank;

public class FindMissingNum {

    public static void main(String[] args) {
        int[] arr = {1, 2, 4, 6, 5, 7};
        int larger = finLargestNumber(arr);
        findMissingNumber(arr, larger);
    }

    private static int finLargestNumber(int[] arr) {
        int largest = arr[0];
        for (int i = 1; i < arr.length; i++) {
            if (arr[i] > largest) {
                largest = arr[i];
            }
        }
        System.out.println(largest + " Larger");
        return largest;
    }

    private static void findMissingNumber(int[] arr, int max) {
        for (int i = 0; i <= max; i++) {
            boolean found = true;
            for (int val : arr) {
                if (i == val) {
                    found = false;
                    break;
                }
            }
            if (found) {
                System.out.println("Missing Number " + i);
            }
        }
    }
}
