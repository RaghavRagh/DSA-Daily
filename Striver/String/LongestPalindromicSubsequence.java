public class LongestPalindromicSubsequence {

    private static int lps(String s) {
        int n = s.length();
        int[][] dp = new int[n][n];

        // Base case: single letter palindromes
        for (int i = 0; i < n; i++) {
            dp[i][i] = 1;
        }

        // Build the table
        for (int len = 2; len <= n; len++) {
            for (int i = 0; i <= n - len; i++) {
                int j = i + len - 1;
                if (s.charAt(i) == s.charAt(j)) {
                    dp[i][j] = dp[i + 1][j - 1] + 2;
                } else {
                    dp[i][j] = Math.max(dp[i + 1][j], dp[i][j - 1]);
                }
            }
        }

        return dp[0][n - 1];
    }

    public static void main(String[] args) {
        String s = "bbbab";
        System.out.println(lps(s));
    }
}