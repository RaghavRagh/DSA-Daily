import java.util.Arrays;

public class Leetcode_2563 {

    private static long countFairPairs(int[] nums, int lower, int upper) {
        Arrays.sort(nums);
        long lessThanUpper = calPairs(nums, upper);
        long lessThanLower = calPairs(nums, lower - 1);
        return lessThanUpper - lessThanLower;
    }

    private static long calPairs(int[] nums, int target) {
        long res = 0;
        int i = 0, j = nums.length - 1;

        while (i < j) {
            if (nums[i] + nums[j] <= target) {
                res += (j - i);
                i++;
            } else {
                j--;
            }
        }

        return res;
    }

    public static void main(String[] args) {
        int[] nums = { 1, 7, 9, 2, 5 };
        int lower = 11, upper = 11;
        System.out.println(countFairPairs(nums, lower, upper));
    }
}
