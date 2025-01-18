package hackerRank;

public class Main {
    public static void main(String[] args) {

//        String vowels = "hello";
//        vowelsFind(vowels);
        String str = "javaj";

        
        for (int i = 0; i < str.length(); i++) {
            char value = str.charAt(i);
            for (int j = i + 1; j < str.length(); j++) {  // Change to j < str.length()
                if (value == str.charAt(j)) {  // Check if the characters are the same
                    System.out.println("Duplicate: " + value);
                    break;  // Exit the inner loop once a duplicate is found
                }
            }
        }

    }
//    public  static  void  vowelsFind(String input) {
//        for (int i = 0; i <= input.length()-1; i++) {
//            char val = input.charAt(i);
//            if ('a' == val ||'e' == val ||'i' == val ||'o' == val ||'u' == val ) {
//                System.out.println(val + " is vowel");
//            }
//        }
//    }
}

//        String str = "java";
//        for(int i=0; i < str.length(); i++){
//            char value = str.charAt(i);
//            for(int j = i + 1 ; j < str.length()-1; j++){
//                System.out.println("values");
//                if( 'j' == str.charAt(j)){
//                    System.out.println("duplicate "+ value);
//                    break;
//                }
//            }
//
//        }

//        ArrayList<String> str = new ArrayList<>();
//        int carCount=0;
//        int houseCount = 0;
//        String carString= "";
//        String houseString= "";
//        str.add("cars");
//        str.add("cars");
//        str.add("house");
//        str.add("house");
//        str.add("tree");
//        str.add("tree");
//        str.add("keyBoard");
//        str.add("keyBoard");
//
//        for(int i = 0 ; i< str.size(); i++) {
//            if(str.get(i).equals(str.get(0))){
//                carCount++;
//                carString = str.get(i);
//
//            }
//            if(str.get(i).equals(str.get(2))){
//                houseCount++;
//                houseString = str.get(i);
//            }
//            for (int j= i+1; j < str.size(); j++) {
//                if ((str.get(i).equals(str.get(j)))) {
//                    System.out.println(str.get(j));
//                }
//            }
//        }
//        System.out.println(carString + "  " + carCount);
//        System.out.println(houseString + "  " + houseCount);
//    }
//    }
//}
//        for(String s : str){
//            if(s.equals("cars")){
//                carCount++;
//            }else {
//                houseCount++;
//            }
//        }