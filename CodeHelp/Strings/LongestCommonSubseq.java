import java.util.Arrays;

public class LongestCommonSubseq {

    private static int lcs(String s1, String s2) {
        int[][] dp = new int[s1.length()][s2.length()];
        for (int[] row : dp) {
            Arrays.fill(row, -1);
        }

        return solve(s1, s2, 0, 0, dp);
    }

    private static int solve(String s1, String s2, int i, int j, int[][] dp) {
        if (i >= s1.length() || j >= s2.length()) {
            return 0;
        }

        if (dp[i][j] != -1) {
            return dp[i][j];
        }

        if (s1.charAt(i) == s2.charAt(j)) {
            return 1 + solve(s1, s2, i + 1, j + 1, dp);
        } else {
            return dp[i][j] = Math.max(solve(s1, s2, i + 1, j, dp), solve(s1, s2, i, j + 1, dp));
        }
    }

    private static int lcsIterative(String s1, String s2) {
        int[][] dp = new int[s1.length() + 1][s2.length() + 1];

        for (int i = s1.length() - 1; i >= 0; i--) {
            for (int j = s2.length() - 1; j >= 0; j--) {
                int ans = 0;
                if (s1.charAt(i) == s2.charAt(j)) {
                    ans = 1 + dp[i + 1][j + 1];
                } else {
                    ans = Math.max(dp[i + 1][j], dp[i][j + 1]);
                }
                dp[i][j] = ans;
            }
        }

        return dp[0][0];
    }

    public static void main(String[] args) {
        String a = "abcde", b = "ace";
        // System.out.println(lcs(a, b));
        System.out.println(lcsIterative(a, b));
    }
}
