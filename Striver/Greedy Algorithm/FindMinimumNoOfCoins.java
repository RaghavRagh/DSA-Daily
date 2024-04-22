import java.util.ArrayList;
import java.util.Arrays;

public class FindMinimumNoOfCoins {

    // static int minCoins(int[] coins, int m, int V) {
    //     if (V == 0) {
    //         return 0;
    //     }

    //     int res = Integer.MAX_VALUE;

    //     for (int i = 0; i < m; i++) {
    //         if (coins[i] <= V) {
    //             int sub_res = minCoins(coins, m, V-coins[i]);

    //             if (sub_res != Integer.MAX_VALUE && sub_res + 1 < res) {
    //                 res = sub_res + 1;
    //             }
    //         }
    //     }

    //     return res;
    // }

    static int minCoins(int[] coins, int m, int V) {
        int[] dp = new int[V + 1];

        Arrays.fill(dp, Integer.MAX_VALUE);

        dp[0] = 0;

        for (int i = 0; i < m; i++) {
            for(int j = coins[i]; j <= V; j++) {
                if (dp[j - coins[i]] != Integer.MAX_VALUE) {
                    dp[j] = Math.min(dp[j], dp[j - coins[i]] + 1);
                }
            }
        }

        if (dp[V] == Integer.MAX_VALUE) {
            return -1;
        } else {
            return dp[V];
        }
    }
    
    public static void main(String[] args) {
        int[] coins = { 9, 6, 5, 1 };
        int m = coins.length;
        int V = 11;
        System.out.println("Minimum coins required is " + minCoins(coins, m, V));
    }
}
