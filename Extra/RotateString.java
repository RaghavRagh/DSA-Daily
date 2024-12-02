public class RotateString {

    private static boolean rotateString(String s, String goal) {
        if (s.length() != goal.length()) {
            return false;
        }

        // String doubledStr = s + s;
        return (s + s).contains(goal);
    }

    public static void main(String[] args) {
        String s = "abcde", goal = "cdeab";
        System.out.println(rotateString(s, goal));
    }
}
