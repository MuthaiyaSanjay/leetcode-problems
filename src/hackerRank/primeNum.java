package hackerRank;

public class primeNum {
    public static void main(String[] args) {
        System.out.println(toCheckPrimeNum(230));
    }

    private static boolean toCheckPrimeNum(int input) {
        if( input == 1 || input == 0 ){
            return false;
        }
        if (input == 2) {
            return true;
        }
        for(int i = 2; i<= input / 2; i++){
            if(input % i == 0){
                return false;
            }
        }
        return true;
    }
}
