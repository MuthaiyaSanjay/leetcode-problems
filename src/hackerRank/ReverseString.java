package hackerRank;

public class ReverseString {
    public static void main(String[] args) {
        String name = "Sanjay";
//        StringBuilder s = new StringBuilder(name);
//        System.out.println(s.reverse());
        for(int i = name.length() -1 ; i >= 0; i--){
            System.out.print(name.charAt(i));
        }
    }
}
