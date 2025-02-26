import java.util.Arrays;

public class ClimbingStairs {

    private static int getTreasure(int n, int[] dp) {
        if (n == 0 || n == 1) {
            return 1;
        }

        if (dp[n] != -1) {
            return dp[n];
        }

        return dp[n] = getTreasure(n - 1, dp) + getTreasure(n - 2, dp);
    }

    public static void main(String[] args) {
        int n = 5;
        int[] dp = new int[n + 1];
        Arrays.fill(dp, -1);

        System.out.println(getTreasure(n, dp));
    }
}
