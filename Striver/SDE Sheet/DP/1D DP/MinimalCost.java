import java.util.Arrays;

public class MinimalCost {

    private static int minimizeCost(int[] arr, int k) {
        if (arr.length <= 1) {
            return 0;
        }

        int[] dp = new int[arr.length];
        Arrays.fill(dp, -1);

        // return solveTopDown(arr, k, arr.length - 1, dp);
        return solveBottomUp(arr, k, dp);
    }

    private static int solveTopDown(int[] arr, int k, int index, int[] dp) {
        if (index == 0) {
            return 0;
        }

        if (dp[index] != -1) {
            return dp[index];
        }

        int minCost = Integer.MAX_VALUE;

        for (int j = 1; j <= k; j++) {
            if (index - j >= 0) {
                int jumpCost = solveTopDown(arr, k, index - j, dp) + Math.abs(arr[index] - arr[index - j]);
                minCost = Math.min(minCost, jumpCost);
            }
        }

        dp[index] = minCost;
        return dp[index];
    }

    private static int solveBottomUp(int[] arr, int k, int[] dp) {
        dp[0] = 0;

        for (int i = 1; i < arr.length; i++) {
            int minCost = Integer.MAX_VALUE;
            for (int j = 1; j <= k; j++) {
                if (i - j >= 0) {
                    int jumpCost = dp[i - j] + Math.abs(arr[i] - arr[i - j]);
                    minCost = Math.min(minCost, jumpCost);
                }
            }
            dp[i] = minCost;
        }

        return dp[arr.length - 1];
    }

    public static void main(String[] args) {
        // int[] arr = { 35, 1, 70, 25, 79, 59, 63, 65 };
        int[] arr = { 10, 30, 40, 50, 20 };
        System.out.println(minimizeCost(arr, 3));
    };
}
