import java.util.Arrays;

public class KnapsackWithDuplicateItems {

    static int knapSack(int N, int W, int val[], int wt[]) {
        if (W <= 0) {
            return 0;
        }

        // return solve(N - 1, W, val, wt);

        int[][] dp = new int[wt.length][W + 1];
        for (int[] row : dp) {
            Arrays.fill(row, -1);
        }

        // return solveTopDown(N - 1, W, val, wt, dp);
        return solveBottomUp(W, val, wt, dp);
    }

    private static int solveTopDown(int index, int W, int[] val, int[] wt, int[][] dp) {
        if (index == 0) {
            return (wt[0] <= W) ? (W / wt[0]) * val[0] : 0;
        }

        if (W == 0) {
            return 0;
        }

        if (dp[index][W] != -1) {
            return dp[index][W];
        }

        int include = 0;
        if (wt[index] <= W) {
            include = val[index] + solveTopDown(index, W - wt[index], val, wt, dp);
        }
        int exclude = solveTopDown(index - 1, W, val, wt, dp);

        return dp[index][W] = Math.max(include, exclude);
    }

    private static int solveBottomUp(int W, int[] val, int[] wt, int[][] dp) {
        for (int w = 0; w <= W; w++) {
            if (wt[0] <= w) {
                dp[0][w] = (w / wt[0]) * val[0];
            }
        }
    
        for (int i = 1; i < wt.length; i++) {
            for (int w = 0; w <= W; w++) {
                int exclude = dp[i - 1][w];
                int include = 0;
                if (wt[i] <= w) {
                    include = val[i] + dp[i][w - wt[i]];
                }
                dp[i][w] = Math.max(include, exclude);
            }
        }
    
        return dp[wt.length - 1][W]; 
    }

    private static int solve(int index, int W, int[] val, int[] wt) {
        if (index == 0) {
            return (wt[0] <= W) ? (W / wt[0]) * val[0] : 0;
        }

        if (W == 0) {
            return 0;
        }

        int include = 0;
        if (wt[index] <= W) {
            include = val[index] + solve(index, W - wt[index], val, wt);
        }
        int exclude = solve(index - 1, W, val, wt);

        return Math.max(include, exclude);
    }

    public static void main(String[] args) {
        int[] val = { 1, 1, 2, 3 };
        int[] wt = { 2, 1, 2, 2 };
        int W = 9;
        System.out.println(knapSack(wt.length, W, val, wt));
    }
}
