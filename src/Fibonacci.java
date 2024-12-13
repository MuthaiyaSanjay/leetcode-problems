import java.util.Scanner;

public class Fibonacci {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int first =0;
        int second = 1;
//        int temp = 0;
        int n = 16;
        System.out.print(first+ ", ");
        System.out.print(second+ ", ");
        for (int i = 3; i <= n; i++){
            int temp = first + second;
            System.out.print(temp+ ", ");
            first = second;
            second = temp;
        }

    }
}
