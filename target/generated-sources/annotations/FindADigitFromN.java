package hackerRank;

public class FindADigitFromN {

    public static void main(String[] args) {
        int digit = 0;
        int number = 100;
        findDigitAndNumber(digit, number);
    }
    public static void findDigitAndNumber(int d , int num){
        int count =0;
        while (num != 0){
            int digit = num % 10;
                if (digit == d){
                    count +=1;
                }
                num= num/10;
        }
        System.out.println(count);
    }
}
