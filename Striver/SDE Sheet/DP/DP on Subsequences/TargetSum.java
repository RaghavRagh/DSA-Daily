import java.util.Arrays;

public class TargetSum {

    public static int findTargetSumWays(int[] nums, int target) {
        int n = nums.length;
        return countSubsetsRecursive(nums, target, n - 1);

        // int sum = Arrays.stream(nums).sum();

        // if ((sum + target) % 2 != 0 || sum < Math.abs(target)) {
        // return 0;
        // }

        // int newTarget = (sum + target) / 2;
        // return countSubsetsIterative(nums, newTarget);
    }

    private static int countSubsetsRecursive(int[] nums, int target, int index) {
        if (index == 0) {
            int ways = 0;
            if ((target - nums[index] == 0))
                ways++;
            if (target + nums[index] == 0)
                ways++;

            return ways;
        }

        int addition = countSubsetsRecursive(nums, target + nums[index], index - 1);
        int subtraction = countSubsetsRecursive(nums, target - nums[index], index - 1);

        return addition + subtraction;
    }

    private static int countSubsetsIterative(int[] nums, int target) {
        int[] dp = new int[target + 1];
        dp[0] = 1; // There's one way to make a sum of 0

        for (int num : nums) {
            for (int t = target; t >= num; t--) {
                dp[t] += dp[t - num];
            }
        }

        return dp[target];
    }

    public static void main(String[] args) {
        int[] nums = { 1, 1, 1, 1, 1 };
        int target = 3;
        System.out.println(findTargetSumWays(nums, target));
    }
}
