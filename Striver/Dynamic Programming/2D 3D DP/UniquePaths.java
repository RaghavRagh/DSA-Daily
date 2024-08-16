public class UniquePaths {

    private static int uniquePaths(int m, int n) {
        int[][] dp = new int[m][n];
        return solveMemoization(m, n, 0, 0, dp);
    }

    private static int solveMemoization(int m, int n, int i, int j, int[][] dp) {
        if (i < 0 || j < 0 || i == m || j == n) {
            return 0;
        }

        if (i == m - 1 && j == n - 1) {
            return 1;
        }

        if (dp[i][j] != 0) {
            return dp[i][j];
        }

        int right = solveMemoization(m, n, i, j + 1, dp);
        int down = solveMemoization(m, n, i + 1, j, dp);

        dp[i][j] = right + down;
        return dp[i][j];
    }

    public static void main(String[] args) {
        int m = 3, n = 7;
        System.out.println(uniquePaths(m, n));
    }
}