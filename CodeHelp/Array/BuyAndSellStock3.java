import java.util.Arrays;

public class BuyAndSellStock3 {

    private static int maxProfit(int[] prices) {
        int minPrice1 = Integer.MAX_VALUE, minPrice2 = Integer.MAX_VALUE;
        int profit1 = 0, profit2 = 0;

        for (int currPrice : prices) {
            minPrice1 = Math.min(currPrice, minPrice1);
            profit1 = Math.max(profit1, currPrice - minPrice1);

            minPrice2 = Math.min(minPrice2, currPrice - profit1);
            profit2 = Math.max(profit2, currPrice - minPrice2);
        }

        return profit2;
    }

    private static int maxProfitTopDown(int[] prices) {
        int n = prices.length;
        int[][][] dp = new int[n][2][3];

        for (int[][] row1 : dp) {
            for (int[] row2 : row1) {
                Arrays.fill(row2, -1);
            }
        }

        return solve(prices, 0, 1, 2, dp);
    }

    private static int solve(int[] prices, int index, int buy, int limit, int[][][] dp) {
        if (index >= prices.length || limit == 0) {
            return 0;
        }

        if (dp[index][buy][limit] != -1) {
            return dp[index][buy][limit];
        }

        int profit = 0;
        if (buy == 1) {
            profit = Math.max((-prices[index] + solve(prices, index + 1, 0, limit, dp)),
                    (0 + solve(prices, index + 1, 1, limit, dp)));
        } else {
            profit = Math.max((prices[index] + solve(prices, index + 1, 1, limit - 1, dp)),
                    (0 + solve(prices, index + 1, 0, limit, dp)));
        }

        return dp[index][buy][limit] = profit;
    }

    private static int maxProfitBottomUp(int[] prices) {
        int n = prices.length;
        int[][][] dp = new int[n + 1][2][3];

        for (int index = n - 1; index >= 0; index--) {
            for (int buy = 0; buy <= 1; buy++) {
                for (int limit = 1; limit <= 2; limit++) {
                    int profit = 0;
                    if (buy == 1) {
                        profit = Math.max((-prices[index] + dp[index + 1][0][limit]),
                                (0 + dp[index + 1][1][limit]));
                    } else {
                        profit = Math.max(prices[index] + dp[index + 1][1][limit - 1],
                                0 + dp[index + 1][0][limit]);
                    }

                    dp[index][buy][limit] = profit;
                }
            }
        }

        return dp[0][1][2];
    }

    public static void main(String[] args) {
        int[] prices = { 3, 3, 5, 0, 0, 3, 1, 4 };
        System.out.println(maxProfit(prices));
        System.out.println(maxProfitTopDown(prices));
        System.out.println(maxProfitBottomUp(prices));
    }
}
