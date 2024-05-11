import java.util.Arrays;

public class FindMinimumNoOfCoins {

    // static int minCoins(int[] coins, int m, int V) {
    //     if (V == 0) {
    //         return 0;
    //     }
    //
    //     int res = Integer.MAX_VALUE;
    //
    //     for (int i = 0; i < m; i++) {
    //         if (coins[i] <= V) {
    //             int sub_res = minCoins(coins, m, V-coins[i]);
    //
    //             if (sub_res != Integer.MAX_VALUE && sub_res + 1 < res) {
    //                 res = sub_res + 1;
    //             }
    //         }
    //     }
    //
    //     return res;
    // }

    // dynamic programming
    static int minCoins(int[] coins, int m, int amount) {
        Arrays.sort(coins);

        int[] dp = new int[amount  + 1];

        for (int i = 1; i < dp.length; i++) {
            dp[i] = Integer.MAX_VALUE;
            for (int coin : coins) {
                if (coin <= i && dp[i - coin] != Integer.MAX_VALUE) {
                    dp[i] = Math.min(dp[i], dp[i - coin] + 1);
                }
            }
        }

        if (dp[amount] == Integer.MAX_VALUE) {
            return -1;
        }

        return dp[amount];
    }
    
    public static void main(String[] args) {
        int[] coins = { 25, 10, 5 };
        int m = coins.length;
        int V = 30  ;
        System.out.println("Minimum coins required is " + minCoins(coins, m, V));
    }
}
