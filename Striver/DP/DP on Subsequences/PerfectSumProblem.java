import java.util.Arrays;

public class PerfectSumProblem {

    private static int perfectSum(int[] arr, int sum) {
        int[][] dp = new int[arr.length][sum + 1];
        for (int[] row : dp) {
            Arrays.fill(row, -1);
        }

        return solve(arr, sum, 0, dp);
    }

    private static int solve(int[] arr, int sum, int index, int[][] dp) {
        if (sum == 0) {
            return 1; 
        }
        
        if (index >= arr.length) {
            return 0;
        }

        if (dp[index][sum] != -1) {
            return dp[index][sum];
        }

        int include = 0;
        if (arr[index] <= sum) {
            include = solve(arr, sum - arr[index], index + 1, dp);
        }

        int exclude = solve(arr, sum, index + 1, dp);
        
        dp[index][sum] = (include + exclude);

        return dp[index][sum];
    }

    public static void main(String[] args) {
        int[] arr = { 1, 0 };
        int sum = 1;
        System.out.println(perfectSum(arr, sum));
    }
}
