public class LongestPalindromeInString {

    private static String longestPalindromeDP(String s) {
        int n = s.length();
        if (n <= 1) {
            return s;
        }

        boolean[][] dp = new boolean[n][n];
        int start = 0;
        int maxLength = 1;
        
        for (int i = 0; i < n; i++) {
            dp[i][i] = true;
        }

        // Check for substrings of length 2
        for (int i = 0; i < n - 1; i++) {
            if (s.charAt(i) == s.charAt(i + 1)) {
                dp[i][i + 1] = true;
                start = i;
                maxLength = 2;
            }
        }

        // Check for substrings of length greater than 2
        for (int length = 3; length <= n; length++) {
            for (int i = 0; i < n - length + 1; i++) {
                int j = i + length - 1; // j is the end index of the current substring
                
                // Check if the current substring is a palindrome
                if (s.charAt(i) == s.charAt(j) && dp[i + 1][j - 1]) {
                    dp[i][j] = true;
                    
                    if (length > maxLength) {
                        start = i;
                        maxLength = length;
                    }
                }
            }
        }

        return s.substring(start, start + maxLength);
    }

    private static String longestPalindrome(String s) {
        if (s.length() <= 1) {
            return s;
        }

        String LPS = "";
        for (int i = 1; i < s.length(); i++) {
            int low = i, high = i;
            while (s.charAt(low) == s.charAt(high)) {
                low--;
                high++;
                if (low < 0 || high >= s.length()) {
                    break;
                }
            }

            String palindrome = s.substring(low + 1, high);
            if (palindrome.length() > LPS.length()) {
                LPS = palindrome;
            }

            // consider even length
            low = i - 1;
            high = i;
            while (s.charAt(low) == s.charAt(high)) {
                low--;
                high++;
                if (low < 0 || high >= s.length()) {
                    break;
                }
            }

            palindrome = s.substring(low + 1, high);
            if (palindrome.length() > LPS.length()) {
                LPS = palindrome;
            }
        }

        return LPS;
    }

    public static void main(String[] args) {
        String s = "abrbadaadab";
        // System.out.println(longestPalindrome(s));
        System.out.println(longestPalindromeDP(s));
    }
}
