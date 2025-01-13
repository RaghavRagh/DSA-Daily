public class BuyAndSellStock {

    private static int maxProfit(int[] prices) {
        int maxProfit = 0, minCost = prices[0];
        
        for (int i : prices) {
            minCost = Math.min(i, minCost);
            int profit = i - minCost;
            maxProfit = Math.max(maxProfit, profit);
        }

        return maxProfit;
    }
    
    public static void main(String[] args) {
        int[] prices = { 7, 1, 5, 3, 6, 4 };
        System.out.println(maxProfit(prices));
    }
}
