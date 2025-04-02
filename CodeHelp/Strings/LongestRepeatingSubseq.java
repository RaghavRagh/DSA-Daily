import java.util.Arrays;

public class LongestRepeatingSubseq {

    private static int lrs(String s) {
        int[][] dp = new int[s.length()][s.length()];
        for (int[] row : dp) {
            Arrays.fill(row, -1);
        }

        return solve(s, 0, 0, dp);
    }

    private static int solve(String s, int i, int j, int[][] dp) {
        if (i >= s.length() || j >= s.length()) {
            return 0;
        }

        if (dp[i][j] != -1) {
            return dp[i][j];
        }

        if (s.charAt(i) == s.charAt(j) && i != j) {
            return 1 + solve(s, i + 1, j + 1, dp);
        } else {
            return dp[i][j] = Math.max(solve(s, i + 1, j, dp), solve(s, i, j + 1, dp));
        }
    }

    public static void main(String[] args) {
        String s = "AABEBCDD";
        System.out.println(lrs(s));
    }
}
