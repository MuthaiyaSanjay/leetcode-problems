package basic;

public class Fibonacci {

    public static void main(String[] args) {
        int first = 0;
        int second = 1;
        System.out.print(first);
        System.out.print(" ," +second);
        for(int i = 1; i <= 10; i++){
            int third = first + second;
            System.out.print(" ," +third);
            first = second;
            second = third;
        }
    }
}
