package hackerRank;

public class FindLargerNumInArr {
    public static void main(String[] args) {
        int[] arr = {12, 45, 23, 67, 89, 2, 56};
        int largest = findLargerValueArr(arr);
        System.out.println("Largest Values "+ largest);
    }

    private static int findLargerValueArr(int[] arr) {
        int largest = 0;
        for(int i=0; i < arr.length -1;i++){
            if(arr[i] > arr[i+1]){
                largest = arr[i];
            }
        }
        return largest;
    }
}
