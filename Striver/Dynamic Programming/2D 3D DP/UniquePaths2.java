public class UniquePaths2 {
    
    private static int uniquePaths2(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        int[][] dp = new int[m][n];
        
        return solveMemoization(grid, m, n, 0, 0, dp);
        // return solveTabulation(grid, m, n, dp);
    }

    private static int solveMemoization(int[][] grid, int m, int n, int i, int j, int[][] dp) {
        if (i < 0 || j < 0 || i > m - 1 || j > n - 1 || grid[i][j] == 1) {
            return 0;
        }

        if (i == m - 1 && j == n - 1) {
            return 1;
        }

        if (dp[i][j] != 0) {
            return dp[i][j];
        }

        int down = solveMemoization(grid, m, n, i + 1, j, dp);
        int right = solveMemoization(grid, m, n, i, j + 1, dp);

        dp[i][j] = down + right;
        return dp[i][j];
    }

    // private static int solveTabulation(int[][] grid, int m, int n, int[][] dp) {
        
    // }
    
    public static void main(String[] args) {
        int[][] grid = new int[3][3];
        grid[1][1] = 1;
        System.out.println(uniquePaths2(grid));
    }
}
