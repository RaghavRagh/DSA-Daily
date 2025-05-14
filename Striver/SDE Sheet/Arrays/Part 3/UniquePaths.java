import java.util.Arrays;

public class UniquePaths {

    static int uniquePaths1(int m, int n) {
        return findPaths1(0, 0, m, n);
    }

    // Approach 1
    // TC-
    private static int findPaths1(int i, int j, int m, int n) {
        if (i == m - 1 && j == n - 1) {
            return 1;
        }

        if (i >= m || j >= n) {
            return 0;
        }

        int rightPaths = findPaths1(i, j + 1, m, n);
        int downPaths = findPaths1(i + 1, j, m, n);

        return rightPaths + downPaths;
    }

    // Approach 2
    static int uniquePaths2(int m, int n) {
        int[][] dp = new int[m][n];
        for (int[] row : dp) {
            Arrays.fill(row, -1);
        }
        return findPaths2(0, 0, m, n, dp);
    }

    private static int findPaths2(int i, int j, int m, int n, int[][] dp) {
        if (i == (m - 1) && j == (n - 1)) {
            return 1;
        }

        if (i >= m || j >= n) {
            return 0;
        }

        if (dp[i][j] != -1) {
            return dp[i][j];
        } else {
            return findPaths2(i + 1, j, m, n, dp) + findPaths2(i, j + 1, m, n, dp);
        }
    }

    // Approach 3
    static int uniquePaths3(int m, int n) {
        int N = m + n - 2;
        int r = m - 1;
        double res = 1;

        for (int i = 1; i <= r; i++) {
            res = res * (N - r + i) / i;
        }

        return (int) res;
    }
    
    public static void main(String[] args) {
        int m = 3;
        int n = 7;
        int ans = uniquePaths3(m, n);
        System.out.println(ans);
    }
}
