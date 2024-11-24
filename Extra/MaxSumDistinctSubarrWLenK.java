import java.util.HashSet;
import java.util.Set;

public class MaxSumDistinctSubarrWLenK {

    private static long maximumSubarraySum(int[] nums, int k) {
        Set<Integer> set = new HashSet<>();
        long maxSum = 0, currSum = 0;
        int start = 0;

        for (int end = 0; end < nums.length; end++) {
            if (!set.contains(nums[end])) {
                currSum += nums[end];
                set.add(nums[end]);
                if (end - start + 1 == k) {
                    maxSum = Math.max(maxSum, currSum);
                    currSum -= nums[start];
                    set.remove(nums[start]);
                    start++;
                }
            } else {
                while (nums[start] != nums[end]) {
                    currSum -= nums[start];
                    set.remove(nums[start]);
                    start++;
                }
                start++;
            }
        }

        return maxSum;
    }

    public static void main(String[] args) {
        int[] nums = { 1, 5, 4, 2, 3, 6, 9, 9, 9 };
        // int[] nums = { 4, 4, 4, 1, 2, 3 };
        int k = 3;
        System.out.println(maximumSubarraySum(nums, k));
    }
}
