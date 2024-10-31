public class dusri {

    int[] res = new int[1];

    private int change(int[] coins, int amount) {
        solve(coins, amount, 0);
        return res[0];
    }

    private int solve(int[] coins, int amount, int index) {
        if (index >= coins.length || amount < 0) {
            return 0;
        }

        if (amount == 0 && index < coins.length) {
            return 1;
        }

        if (coins[index] <= amount && index < coins.length) {
            res[0] += solve(coins, amount - coins[index], index);
        }

        solve(coins, amount, index + 1);

        return res[0];
    }

    public static void main(String[] args) {
        int[] coins = { 1, 2, 5 };
        System.out.println(new dusri().change(coins, 5));
    }
}