package hackerRank;

public class Mcq {
    public static void main(String[] args) {
//        int Integer = 24;
//        char Mcq  = 'I';
//        System.out.print(Integer);
//        System.out.print(Mcq);
//
//        short x = 10;
//        x =  (short) (x * 5);
//        System.out.print(x);
//
//        byte x = 127;
//        x++;
//        x++;
//        System.out.print(x);
//        int[]  x = {120, 200, 010};
//        for(int i = 0; i < x.length; i++) {
//            System.out.print(x[i] + " ");
//        }
//        int[] A = {0,2,4,1,3};
//        for(int i = 0; i < A.length; i++){
//            A[i] = A[(A[i] + 3) % A.length];
//            System.out.println(A[i]);
//        }

//        System.out.println(vowelOrNot("htll"));
//     int a = 10;
//     int b = 20;
//     b = b+a;
//     a = b-a;
//     b = b-a;
//        System.out.println(a +" : " + b);
    }


    private static boolean vowelOrNot(String str) {
        return str.toLowerCase().matches(".*[aeiou].*");
    }
}
