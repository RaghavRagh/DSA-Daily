// 53
// https://leetcode.com/problems/maximum-subarray/description/

public class MaximumSubarray {

    static int maxSubArray(int[] nums) {
        int max = nums[0];
        int sum = 0;

        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
            max = Math.max(sum, max);

            if (sum < 0) {
                sum = 0;
            }
        }

        return max;
    }

    public static void main(String[] args) {
        int[] nums = { -2, 1, -3, 4, -1, 2, 1, -5, 4 };
        int max = maxSubArray(nums);
        System.out.println(max);
    }
}
