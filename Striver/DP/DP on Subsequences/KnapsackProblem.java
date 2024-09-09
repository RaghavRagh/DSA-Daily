import java.util.Arrays;

public class KnapsackProblem {

    private static int knapsack(int W, int[] profit, int[] weight) {
        int n = weight.length;
        // return solve(W, profit, weight, n - 1);

        int[][] dp = new int[n + 1][W + 1];
        for (int[] row : dp) {
            Arrays.fill(row, -1);
        }

        // return solveMem(W, profit, weight, n - 1, dp);
        // return solveTab(W, profit, weight, n);
        return solveTabSpaceOptimization(W, profit, weight, n);
    }

    private static int solveMem(int W, int[] profit, int[] weight, int index, int[][] dp) {
        if (index == 0) {
            if (weight[0] <= W) {
                return profit[0];
            } else {
                return 0;
            }
        }

        if (dp[index][W] != -1) {
            return dp[index][W];
        }

        int include = 0;
        if (weight[index] <= W) {
            include = profit[index] + solveMem(W - weight[index], profit, weight, index - 1, dp);
        }

        int exclude = solveMem(W, profit, weight, index - 1, dp);

        return dp[index][W] = Math.max(include, exclude);
    }

    private static int solveTab(int capacity, int[] profit, int[] weight, int n) {
        int[][] dp = new int[n][capacity + 1];

        for (int w = 0; w <= capacity; w++) {
            dp[0][w] = weight[0] <= w ? profit[0] : 0;
        }

        for (int index = 1; index < n; index++) {
            for (int w = 0; w <= capacity; w++) {
                int include = 0;
                if (weight[index] <= w) {
                    include = profit[index] + dp[index - 1][w - weight[index]];
                }

                int exclude = dp[index - 1][w];
                dp[index][w] = Math.max(include, exclude);
            }
        }

        return dp[n - 1][capacity];
    }

    // Space Optimization in Tabulation 
    private static int solveTabSpaceOptimization(int capacity, int[] profit, int[] weight, int n) {
        // current row is dependent on the previous row
        int[] prev = new int[capacity + 1];
        int[] curr = new int[capacity + 1];

        for (int w = 0; w <= capacity; w++) {
            prev[w] = weight[0] <= w ? profit[0] : 0;
        }

        for (int index = 1; index < n; index++) {
            for (int w = 0; w <= capacity; w++) {
                int include = 0;
                if (weight[index] <= w) {
                    include = profit[index] + prev[w - weight[index]];
                }

                int exclude = prev[w];
                curr[w] = Math.max(include, exclude);
            }
            prev = curr.clone();
        }

        return prev[capacity];
    }

    private static int solve(int W, int[] profit, int[] weight, int index) {
        if (index == 0) {
            if (weight[0] <= W) {
                return profit[0];
            } else {
                return 0;
            }
        }

        int include = 0;
        if (weight[index] <= W) {
            include = profit[index] + solve(W - weight[index], profit, weight, index - 1);
        }

        int exclude = solve(W, profit, weight, index - 1);

        return Math.max(include, exclude);
    }

    public static void main(String[] args) {
        int[] weight = { 4, 5, 1 };
        int[] profit = { 1, 2, 3 };
        int W = 4;
        System.out.println(knapsack(W, profit, weight));
    }
}
