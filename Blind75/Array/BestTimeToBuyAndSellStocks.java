// 121
// https://leetcode.com/problems/best-time-to-buy-and-sell-stock/description/

public class BestTimeToBuyAndSellStocks {
    // Approach 1
    void maxProfit1(int[] prices) {
        int minCost = prices[0];
        int maxProfit = 0;

        for (int i = 0; i < prices.length; i++) {
            minCost = Math.min(minCost, prices[i]);
            int tempProfit = prices[i] - minCost;
            maxProfit = Math.max(maxProfit, tempProfit);
        }

        System.out.println("Max Profit: " + maxProfit);
    }

    // Approach 2
    void maxProfit2(int[] prices) {
        int maxRight = prices[prices.length - 1];
        int maxProfit = 0;

        for (int i = prices.length - 1; i >= 0; i--) {
            int tempProfit = maxRight - prices[i];
            maxProfit = Math.max(maxProfit, tempProfit);
        
            if (maxRight < prices[i]) {
                maxRight = prices[i];
            }
        }

        System.out.println("Max Profit: " + maxProfit);
    }

    public static void main(String[] args) {
        BestTimeToBuyAndSellStocks obj = new BestTimeToBuyAndSellStocks();
        int[] arr = { 7, 1, 5, 3, 6, 4 };
        // obj.maxProfit1(arr);
        obj.maxProfit2(arr);
    }
}