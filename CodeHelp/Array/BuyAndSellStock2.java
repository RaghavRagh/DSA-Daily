import java.util.Arrays;

public class BuyAndSellStock2 {

    private static int maxProfit(int[] prices) {
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

    public static void main(String[] args) {
        int[] prices = { 7, 1, 5, 3, 6, 4 };
        System.out.println(maxProfit(prices));
    }
}
