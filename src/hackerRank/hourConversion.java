package hackerRank;
// time conversion hacker rank
public class hourConversion {
    public static void main(String[] args) {
        String hour = "07:05:45AM";
        String ans = conversion(hour);
        System.out.println(ans);
    }

    private static String conversion(String s) {
        String period = s.substring(s.length() - 2);
        int hour = Integer.parseInt(s.substring(0, 2));
        if (period.equals("AM")) {
            if (hour == 12) {
                s = "00" + s.substring(2, s.length() - 2);
            } else {
                s = s.substring(0, s.length() - 2);
            }
        } else {
            if (hour != 12) {
                hour += 12;
                s = hour + s.substring(2, s.length() - 2);
            } else {
                s = s.substring(0, s.length() - 2);
            }
        }
        return s;
    }
}
