package basic;

public class DuplicateString {
    public static void main(String[] args) {
        String input = "java";
//        String duplicate="";
        for (int i =0; i< input.length(); i++){
            for(int j = i+1; j< input.length(); j++){
                if(input.charAt(i) == input.charAt(j)){
                    System.out.println("Duplicate value is " + input.charAt(i));
                }
            }
        }
    }
}
