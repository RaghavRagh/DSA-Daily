import java.util.Arrays;

public class ZeroOneKanpsack {

    private static int knapsack(int w, int[] weight, int[] values, int n) {
        // return solveRec(w, weight, values, n - 1);

        int[][] dp = new int[n][w + 1];
        for (int[] i : dp) {
            Arrays.fill(i, -1);
        }
        
        return solveDpTopDown(w, weight, values, n - 1, dp);
    }

    private static int solveRec(int capacity, int[] weight, int[] values, int index) {
        // base case
        if (index == 0) {
            if (weight[0] <= capacity) {
                return values[0];
            } else {
                return 0;
            }
        }

        int include = 0;
        if (weight[index] <= capacity) {
            include = values[index] + solveRec(capacity - weight[index], weight, values, index - 1);
        }

        int exclude = solveRec(capacity, weight, values, index - 1);

        int ans = Math.max(include, exclude);
        return ans;
    }

    // top-down approach
    // TC = O(n * w)
    // SC = O(n * (w + 1))
    private static int solveDpTopDown(int capacity, int[] weight, int[] values, int index, int[][] dp) {
        // base case
        if (index == 0) {
            if (weight[0] <= capacity) {
                return values[0];
            } else {
                return 0;
            }
        }

        if (dp[index][capacity] != -1) {
            return dp[index][capacity];
        }

        int include = 0;
        if (weight[index] <= capacity) {
            include = values[index] + solveDpTopDown(capacity - weight[index], weight, values, index - 1, dp);
        }

        int exclude = solveDpTopDown(capacity, weight, values, index - 1, dp);

        dp[index][capacity] = Math.max(include, exclude);
        return dp[index][capacity];
    }

    private static int solveBottomUp(int w, int[] weight, int[] values, int n) {
        int[][] dp = new int[n + 1][w + 1];

        for (int i = 1; i < dp.length; i++) {
            for (int capacity = 0; capacity <= w; capacity++) {
                if (weight[i - 1] <= capacity) {
                    dp[i][capacity] = Math.max(dp[i - 1][capacity], values[i - 1] + dp[i - 1][capacity - weight[i - 1]]);
                } else {
                    dp[i][capacity] = dp[i - 1][capacity];
                }
            }
        }

        return dp[n][w];
    }
    
    public static void main(String[] args) {
        int[] values = { 1, 2, 3 };
        int[] weight = { 4, 5, 1 };
        int w = 4;
        int n = values.length;
        // System.out.println(knapsack(w, weight, values, n));
        System.out.println(solveBottomUp(w, weight, values, n));
    }
}
