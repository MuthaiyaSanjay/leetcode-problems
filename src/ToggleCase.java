public class ToggleCase {

    public static void main(String[] args) {
        String input = "jaVaTpoiNt";
        String res = javaToggle(input);
        System.out.println(res);
    }

    private static String javaToggle(String input) {
        StringBuilder toggledString = new StringBuilder();
        for (int i = 0; i < input.length(); i++) {
            char val = input.charAt(i);
            if (Character.isLowerCase(val)) {
                toggledString.append(Character.toUpperCase(val));
            } else {
                toggledString.append(Character.toLowerCase(val));
            }
        }
        return toggledString.toString();
    }
}
