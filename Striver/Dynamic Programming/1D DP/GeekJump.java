import java.util.Arrays;

public class GeekJump {

    private static int minEnergy(int[] height, int n) {
        if (n <= 1) {
            return 0;
        }

        int[] dp = new int[n];
        Arrays.fill(dp, -1);
        
        // return solveTopDown(height, n - 1, dp);
        // return solveBottomUp(height, n, dp);
        return solveSpaceOptimize(height, n);
    }

    private static int solveTopDown(int[] height, int index, int[] dp) {
        if (index == 0) {
            return 0;
        }

        if (dp[index] != -1) {
            return dp[index];
        }

        int firstJump = solveTopDown(height, index - 1, dp) + Math.abs(height[index] - height[index - 1]);
        int secondJump = Integer.MAX_VALUE;

        if (index > 1) {
            secondJump = solveTopDown(height, index - 2, dp) + Math.abs(height[index] - height[index - 2]);
        }

        dp[index] = Math.min(firstJump, secondJump);
        return dp[index];
    }

    private static int solveBottomUp(int[] height, int n, int[] dp) {
        dp[0] = 0;
        dp[1] = Math.abs(height[1] - height[0]);

        for (int i = 2; i < n; i++) {
            int firstJump = dp[i - 1] + Math.abs(height[i] - height[i - 1]);
            int secondJump = dp[i - 2] + Math.abs(height[i] - height[i - 2]);
            dp[i] = Math.min(firstJump, secondJump);
        }

        return dp[n - 1];
    }

    private static int solveSpaceOptimize(int[] height, int n) {
        int prev1 = 0, prev2 = 0;

        for (int i = 1; i < n; i++) {
            int firstJump = prev1 + Math.abs(height[i] - height[i - 1]);
            int secondJump = Integer.MAX_VALUE;
            if (i > 1) {
                secondJump = prev2 + Math.abs(height[i] - height[i - 2]);
            }

            int curr = Math.min(firstJump, secondJump);
            prev2 = prev1;
            prev1 = curr;
        }

        return prev1;
    }

    public static void main(String[] args) {
        int[] height = { 30, 10, 60, 10, 60, 50 };
        System.out.println(minEnergy(height, height.length));
    }
}
