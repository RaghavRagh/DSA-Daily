public class StringToInteger {

    private static int myAtoi(String s) {
        s = s.trim();
        if (s.length() < 1) {
            return 0;
        }

        char sign = '+';
        int i = 0;

        if (s.charAt(i) == '-') {
            sign = '-';
            i++;
        } else if (s.charAt(i) == '+') {
            sign = '+';
            i++;
        }

        double result = 0;

        while (i < s.length() && s.charAt(i) >= '0' && s.charAt(i) <= '9') {
            result = result * 10 + (s.charAt(i) - '0');
            i++;
        }

        if (sign == '-') {
            result = -result;
        }

        if (result > Integer.MAX_VALUE) {
            return Integer.MAX_VALUE;
        } else if (result < Integer.MIN_VALUE) {
            return Integer.MIN_VALUE;
        }

        return (int) result;
    }

    public static void main(String[] args) {
        String s = "2147483648";
        System.out.println(myAtoi(s));
    }
}
