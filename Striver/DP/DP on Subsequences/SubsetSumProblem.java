import java.util.Arrays;

public class SubsetSumProblem {

    private static Boolean isSubsetSum(int n, int[] arr, int sum) {
        Boolean[][] dp = new Boolean[n + 1][sum + 1];
        for (Boolean[] row : dp) {
            Arrays.fill(row, null);
        }

        // return solveMemoization(arr, sum, n, dp);
        return solveTabulation(n, arr, sum);
    }

    private static boolean solveMemoization(int[] arr, int sum, int index, Boolean[][] dp) {
        if (sum == 0) {
            return true;
        }

        if (index == 0) {
            return false;
        }

        if (dp[index][sum] != null) {
            return dp[index][sum];
        }

        boolean include = false;
        if (arr[index - 1] <= sum) {
            include = solveMemoization(arr, sum - arr[index - 1], index - 1, dp);
        }

        boolean exclude = solveMemoization(arr, sum, index - 1, dp);

        dp[index][sum] = exclude || include;
        return dp[index][sum];
    }

    private static Boolean solveTabulation(int n, int[] arr, int sum) {
        boolean[][] dp = new boolean[n + 1][sum + 1];
        // If j = 0, then dp[i][0] = true for all i because a sum of 0 can always be achieved by selecting no elements.
        // If i = 0 and j > 0, then dp[0][j] = false because with zero elements, you can't achieve a non-zero sum.
        for (int i = 0; i <= n; i++) {
            dp[i][0] = true;
        }

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= sum; j++) {
                if (arr[i - 1] <= j) {
                    dp[i][j] = dp[i - 1][j] || dp[i - 1][j - arr[i - 1]];
                } else {
                    dp[i][j] = dp[i  - 1][j];
                }
            }
        }

        return dp[n][sum];
    }

    public static void main(String[] args) {
        int[] arr = { 3, 34, 4, 12, 5, 2 };
        int sum = 9;
        System.out.println(isSubsetSum(arr.length, arr, sum));
    }
}