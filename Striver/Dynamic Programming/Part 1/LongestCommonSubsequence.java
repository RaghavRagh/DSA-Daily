import java.util.Arrays;

public class LongestCommonSubsequence {
    
    // iteratively 
    // TC - O(n x m)
    // SC - O(n x m)
    private static int lcsIterative(String text1, String text2) {
        int[][] dp = new int[text1.length() + 1][text2.length() + 1];

        for (int i = 1; i <= text1.length(); i++) {
            for (int j = 1; j <= text2.length(); j++) {
                if (text1.charAt(i - 1) == text2.charAt(j - 1)) {
                    dp[i][j] = 1 + dp[i - 1][j - 1];
                } else {
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
                }
            }
        }

        return dp[text1.length()][text2.length()];
    }

    // recursively
    private static int lcsRecursive(String text1, String text2) {
        int[][] dp = new int[text1.length() + 1][text2.length() + 1];
        for (int[] i : dp) {
            Arrays.fill(i, -1);
        }

        return solve(text1, text2, 0, 0, dp);
    }

    private static int solve(String text1, String text2, int i, int j, int[][] dp) {
        // base case
        if (i == text1.length() || j == text2.length()) {
            return 0;
        }

        if (dp[i][j] != -1) {
            return dp[i][j];
        }

        int ans = 0;
        if (text1.charAt(i) == text2.charAt(j)) {
            ans = 1 + solve(text1, text2, i + 1, j + 1, dp);
        } else {
            ans = Math.max(solve(text1, text2, i + 1, j, dp), solve(text1, text2, i, j + 1, dp));
        }

        return dp[i][j] = ans;
    }
    
    public static void main(String[] args) {
        String text1 = "abcde";
        String text2 = "ace";
        System.out.println(lcsIterative(text1, text2));
        System.out.println(lcsRecursive(text1, text2));
    }
}
