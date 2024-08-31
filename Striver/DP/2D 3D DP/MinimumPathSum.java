public class MinimumPathSum {

    private static int minPathSum(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        int[][] dp = new int[m][n];

        // return solveMemoization(grid, m, n, 0, 0, dp);
        return solveTabulation(grid, m, n, dp);
    }

    private static int solveMemoization(int[][] grid, int m, int n, int i, int j, int[][] dp) {
        if (i >= m || j >= n) {
            return Integer.MAX_VALUE;
        }

        if (i == m - 1 && j == n - 1) {
            return grid[i][j];
        }

        if (dp[i][j] != 0) {
            return dp[i][j];
        }

        int down = solveMemoization(grid, m, n, i + 1, j, dp);
        int right = solveMemoization(grid, m, n, i, j + 1, dp);

        dp[i][j] = grid[i][j] + Math.min(down, right);
        return dp[i][j];
    }

    private static int solveTabulation(int[][] grid, int m, int n, int[][] dp) {
        dp[0][0] = grid[0][0];
        
        // fill the first row
        for (int j = 1; j < n; j++) {
            dp[0][j] = dp[0][j - 1] + grid[0][j];
        }

        // fill the first column
        for (int i = 1; i < m; i++) {
            dp[i][0] = dp[i - 1][0] + grid[i][0];
        }

        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                dp[i][j] = grid[i][j] + Math.min(dp[i - 1][j], dp[i][j - 1]);
            }
        }

        return dp[m - 1][n - 1];
    }

    public static void main(String[] args) {
        int[][] grid = { 
            { 1, 3, 1 }, 
            { 1, 5, 1 }, 
            { 4, 2, 1 } 
        };

        System.out.println(minPathSum(grid));
    }
}
