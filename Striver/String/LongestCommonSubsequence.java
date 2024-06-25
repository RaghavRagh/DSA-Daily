import java.util.Arrays;

public class LongestCommonSubsequence {

    private static int lcs(String text1, String text2) {
        int[][] dp = new int[text1.length() + 1][text2.length() + 1];
        for (int[] arr : dp) {
            Arrays.fill(arr, -1);
        }
        return solve(text1, text2, 0, 0, dp);
    }

    private static int solve(String a, String b, int i, int j, int[][] dp) {
        // base case
        if (i == a.length() || j == b.length()) {
            return 0;
        }

        if (dp[i][j] != -1)
            return dp[i][j];

        int ans = 0;
        if (a.charAt(i) == b.charAt(j)) {
            ans = 1 + solve(a, b, i + 1, j + 1, dp);
        } else {
            ans = Math.max(solve(a, b, i + 1, j, dp), solve(a, b, i, j + 1, dp));
        }

        return dp[i][j] = ans;
    }

    public static void main(String[] args) {
        String text1 = "ezupkr";
        String text2 = "ubmrapg";
        System.out.println(lcs(text1, text2));
    }
}
