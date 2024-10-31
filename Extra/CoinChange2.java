import java.util.Arrays;

public class CoinChange2 {

    private int change(int[] coins, int amount) {
        return solve(coins, amount, 0);

        // int[][] dp = new int[coins.length][amount + 1];
        // for (int[] row : dp) {
        //     Arrays.fill(row, -1);
        // }
        // return solveTopDown(coins, amount, 0, dp);

    }

    private int solveTopDown(int[] coins, int amount, int index, int[][] dp) {
        if (amount < 0 || index >= coins.length) {
            return 0;
        }

        if (amount == 0) {
            return 1;
        }

        if (dp[index][amount] != -1) {
            return dp[index][amount];
        }

        int includeCurrCoin = solveTopDown(coins, amount - coins[index], index, dp);
        int excludeCurrCoin = solveTopDown(coins, amount, index + 1, dp);

        return dp[index][amount] = includeCurrCoin + excludeCurrCoin;
    }

    private int solve(int[] coins, int amount, int index) {
        if (amount < 0 || index >= coins.length) {
            return 0;
        }

        if (amount == 0) {
            return 1;
        }

        int includeCurrCoin = solve(coins, amount - coins[index], index);
        int excludeCurrCoin = solve(coins, amount, index + 1);

        return includeCurrCoin + excludeCurrCoin;
    }

    public static void main(String[] args) {
        int[] coins = { 1, 2, 5 };
        System.out.println(new CoinChange2().change(coins, 5));
    }
}
