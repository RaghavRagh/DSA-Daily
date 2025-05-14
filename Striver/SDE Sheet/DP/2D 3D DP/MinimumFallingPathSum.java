import java.util.Arrays;

public class MinimumFallingPathSum {

    private static int minFallingPathSum(int[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;
        int[][] dp = new int[m][n];
        
        for (int[] arr : dp) {
            Arrays.fill(arr, -1);
        }

        int minSum = Integer.MAX_VALUE;

        for (int j = 0; j < n; j++) {
            minSum = Math.min(minSum, solveMemoization(matrix, m, n, 0, j, dp));
        }

        return minSum;
    }

    private static int solveMemoization(int[][] matrix, int m, int n, int i, int j, int[][] dp) {
        if (j < 0 || j >= n) {
            return Integer.MAX_VALUE;
        }

        if (i == m - 1) {
            return matrix[i][j];
        }

        if (dp[i][j] != -1) {
            return dp[i][j];
        }

        int downLeft = solveMemoization(matrix, m, n, i + 1, j - 1, dp);
        int down = solveMemoization(matrix, m, n, i + 1, j, dp);
        int rightBottom = solveMemoization(matrix, m, n, i + 1, j + 1, dp);

        dp[i][j] = matrix[i][j] + Math.min(downLeft, Math.min(down, rightBottom));
        return dp[i][j];
    }
    
    public static void main(String[] args) {
        int[][] matrix = { { 2, 1, 3 }, { 6, 5, 4 }, { 7, 8, 9 } };
        System.out.println(minFallingPathSum(matrix));
    }
}
