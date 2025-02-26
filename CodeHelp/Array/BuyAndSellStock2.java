import java.util.Arrays;

public class BuyAndSellStock2 {

    // using simple approach
    private static int maxProfit(int[] prices) {
        int profit = 0;
        for (int i = 1; i < prices.length; i++) {
            if (prices[i - 1] < prices[i]) {
                profit += (prices[i] - prices[i - 1]);
            }
        }

        return profit;
    }

    // using top down dp
    private static int maxProfitTopDown(int[] prices) {
        int n = prices.length;
        int[][] dp = new int[n][2];

        for (int[] row : dp) {
            Arrays.fill(row, -1);
        }

        return solve(0, 1, prices, dp);
    }

    private static int solve(int index, int buy, int[] prices, int[][] dp) {
        if (index == prices.length) {
            return 0;
        }

        if (dp[index][buy] != -1) {
            return dp[index][buy];
        }

        int profit = 0;
        if (buy == 1) {
            int buyKaro = -prices[index] + solve(index + 1, 0, prices, dp);
            int skipKaro = 0 + solve(index + 1, 1, prices, dp);
            profit = Math.max(buyKaro, skipKaro);
            // profit = Math.max((-prices[index] + solve(index + 1, false, prices)), (0 +
            // solve(index + 1, true, prices)));
        } else {
            int sellKaro = prices[index] + solve(index + 1, 1, prices, dp);
            int skipKaro = 0 + solve(index + 1, 0, prices, dp);
            profit = Math.max(sellKaro, skipKaro);
            // profit = Math.max((prices[index] + solve(index + 1, true, prices)), (0 +
            // solve(index + 1, false, prices)));
        }

        return dp[index][buy] = profit;
    }

    private static int maxProfitBottomUp(int[] prices) {
        int n = prices.length;
        // int[][] dp = new int[n + 1][2];

        int[] curr = new int[2];
        int[] next = new int[2]; 

        for (int index = n - 1; index >= 0; index--) {
            for (int buy = 0; buy <= 1; buy++) {
                int profit = 0;
                if (buy == 1) {
                    // int buyKaro = -prices[index] + dp[index + 1][0];
                    int buyKaro = -prices[index] + next[0];
                    int skipKaro = 0 + next[1];
                    profit = Math.max(buyKaro, skipKaro);
                } else {
                    int sellKaro = prices[index] + next[1];
                    int skipKaro = 0 + next[0];
                    profit = Math.max(sellKaro, skipKaro);
                }

                curr[buy] = profit;
            }

            next = curr.clone();
        }

        return next[1];
    }

    public static void main(String[] args) {
        int[] prices = { 7, 1, 5, 3, 6, 4 };
        System.out.println(maxProfit(prices));
        System.out.println(maxProfitTopDown(prices));
        System.out.println(maxProfitBottomUp(prices));
    }
}
