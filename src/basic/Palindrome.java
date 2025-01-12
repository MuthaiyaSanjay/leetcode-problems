package basic;

import java.util.HashMap;
import java.util.Map;

public class Palindrome {
    public static void main(String[] args) {
//        int pal = 232;
//        int num = pal;
//        int sum=0,r;
//        while (num > 0){
//            r = num%10;
//            sum = (sum*10) + r;
//            num = num/10;
//        }
//        if(pal == sum){
//            System.out.println("palind");
//        }else {
//            System.out.println("NON");
//        }
//        String str = "sts3";
//        char[] ch ={};
//        for(int i =str.length()-1; i >= 0 ;i--){
//
//            System.out.print(str.charAt(i));
//        }

//        String pattern = "yyyy-MM-dd";
//        SimpleDateFormat simpleDateFormat = new SimpleDateFormat(pattern);
//        String date = simpleDateFormat.format(new Date());
//        System.out.println(date);

        String str = "abcdABCDabcdABCD";
        Map<Character, Integer> count = new HashMap<>();
        char[] c = str.toCharArray();
        for (char val : c) {
            if (count.containsKey(val)) {
                count.put(val, count.get(val) + 1);
            } else {
                count.put(val, 1);
            }
        }
        System.out.println(count);
    }
}
