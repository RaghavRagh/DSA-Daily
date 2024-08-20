public class MinimumPathSum {

    private static int minPathSum(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        int[][] dp = new int[m][n];

        return solve(grid, m, n, 0, 0, dp);
    }

    private static int solve(int[][] grid, int m, int n, int i, int j, int[][] dp) {
        if (i >= m || j >= n) {
            return Integer.MAX_VALUE;
        }

        if (i == m - 1 && j == n - 1) {
            return grid[i][j];
        }

        if (dp[i][j] != 0) {
            return dp[i][j];
        }

        int down = solve(grid, m, n, i + 1, j, dp);
        int right = solve(grid, m, down, i, j + 1, dp);

        dp[i][j] = grid[i][j] + Math.min(down, right);
        return dp[i][j];
    }
    
    public static void main(String[] args) {
        int[][] grid = new int[3][3];
        int[] val = { 1, 3, 1, 1, 5, 1, 4, 2, 1 };

        int k = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                grid[i][j] = val[k++];
            }
        }

        System.out.println(minPathSum(grid));
    }
}
