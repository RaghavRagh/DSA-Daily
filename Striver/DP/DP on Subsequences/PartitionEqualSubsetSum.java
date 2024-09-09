import java.util.Arrays;

public class PartitionEqualSubsetSum {

    private static boolean canPartition(int[] nums) {
        int sum = Arrays.stream(nums).sum();
        if (sum % 2 != 0)
            return false;

        int n = nums.length;
        int target = sum / 2;

        Boolean[][] dp = new Boolean[n + 1][target + 1];
        for (Boolean[] row : dp) {
            Arrays.fill(row, null);
        }

        // return solveMemo(nums, 0, target, dp);
        return solevTab(nums, target);
    }

    private static boolean solveMemo(int[] nums, int index, int target, Boolean[][] dp) {
        if (index >= nums.length || target < 0) {
            return false;
        }

        if (target == 0) {
            return true;
        }

        if (dp[index][target] != null) {
            return dp[index][target];
        }

        boolean included = solveMemo(nums, index + 1, target - nums[index], dp);
        boolean excluded = solveMemo(nums, index + 1, target, dp);

        return dp[index][target] = included || excluded;
    }

    private static boolean solevTab(int[] nums, int total) {
        boolean[][] dp = new boolean[nums.length + 1][total + 1];

        for (int i = 0; i < dp.length; i++) {
            dp[i][0] = true;
        }

        for (int index = nums.length - 1; index >= 0; index--) {
            for (int target = 0; target <= total; target++) {
                
                boolean included = false;
                if (target - nums[index] >= 0) {
                    included = dp[index + 1][target - nums[index]];
                }

                boolean excluded = dp[index + 1][target];
                dp[index][target] = included || excluded;
            }
        }

        return dp[0][total];
    }

    public static void main(String[] args) {
        int[] nums = { 1, 5, 11, 5  };  
        System.out.println(canPartition(nums));
    }
}
