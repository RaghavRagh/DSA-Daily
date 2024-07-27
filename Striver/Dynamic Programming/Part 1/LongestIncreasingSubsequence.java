import java.util.Arrays;

public class LongestIncreasingSubsequence {

    private static void lengthOfLIS(int[] nums) {
        // return solve(nums, nums.length, 0, -1);
        if (nums.length == 0) {
            return;
        }

        int[] dp = new int[nums.length];

        Arrays.fill(dp, 1);

        for (int i = 1; i < nums.length; i++) {
            if (nums[i] > nums[i - 1]) {
                dp[i] = Math.max(dp[i], dp[i] + 1);
            }
        }

        for (int i : dp) {
            System.out.print(i + " ");
        }
    }

    // private static int solve(int[] nums, int n, int curr, int prev) {

    // }

    public static void main(String[] args) {
        int[] nums = { 10, 9, 2, 5, 3, 7, 101, 18 };
        // int[] nums = { 10, 22, 9, 33 };
        // System.out.println(lengthOfLIS(nums));
        lengthOfLIS(nums);
    }
}
