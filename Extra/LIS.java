import java.util.Arrays;

public class LIS {

    private static int lengthOfLIS(int[] arr) {
        int[][] dp = new int[arr.length][arr.length + 1];
        for (int[] row : dp) {
            Arrays.fill(row, -1);
        }

        return solveTopdown(arr, 0, -1, dp);
        // return solveBottomup(arr);
    }

    private static int solveTopdown(int[] arr, int curr, int prev, int[][] dp) {
        if (curr == arr.length) {
            return 0;
        }

        if (dp[curr][prev + 1] != -1) {
            return dp[curr][prev + 1];
        }

        int include = 0;
        if (prev == -1 || arr[prev] < arr[curr]) {
            include = 1 + solveTopdown(arr, curr + 1, curr, dp);
        }

        int exclude = solveTopdown(arr, curr + 1, prev, dp);

        return dp[curr][prev + 1] = Math.max(include, exclude);
    }

    private static int solveBottomup(int[] arr) {
        int[] dp = new int[arr.length];
        Arrays.fill(dp, 1);

        for (int i = 1; i < dp.length; i++) {
            for (int j = 0; j <= i; j++) {
                if (arr[j] < arr[i]) {
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
            }
        }

        return Arrays.stream(dp).max().getAsInt();
    }

    public static void main(String[] args) {
        int[] arr = { 10, 9, 2, 5, 3, 7, 101, 18 };
        System.out.println(lengthOfLIS(arr));
    }
}
