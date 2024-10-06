public class LongestPalindrome {

    private static String longestPalindrome(String s) {
        if (s.length() <= 1) {
            return s;
        }

        String LPS = "";
        for (int i = 1; i < s.length(); i++) {
            int left = i, right = i;
            while (s.charAt(left) == s.charAt(right)) {
                left--;
                right++;
                if (left == -1 || right == s.length()) {
                    break;
                }
            }

            String palindrome = s.substring(left + 1, right);
            if (palindrome.length() > LPS.length()) {
                LPS = palindrome;
            }

            // consider even length
            left = i - 1;
            right = i;
            while (s.charAt(left) == s.charAt(right)) {
                left--;
                right++;

                if (left == -1 || right == s.length()) {
                    break;
                }
            }

            palindrome = s.substring(left + 1, right);
            if (palindrome.length() > LPS.length()) {
                LPS = palindrome;
            }
        }

        return LPS;
    }

    public static void main(String[] args) {
        String s = "babad";
        System.out.println(longestPalindrome(s));
    }
}
