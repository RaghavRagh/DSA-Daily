// 153
// https://leetcode.com/problems/find-minimum-in-rotated-sorted-array/description/

public class MinimumInRotatedSortedArray {

    static int findMin(int[] nums) {
        int start = 0;
        int end = nums.length - 1;

        while (start < end) {
            int mid = start + (end - start) / 2;

            if (nums[mid] > nums[end]) {
                start = mid + 1;
            } else {
                end = mid;
            }
        }

        return nums[end];
    }

    public static void main(String[] args) {
        // int nums[] = { 3, 4, 5, 1, 2 };
        int nums[] = { 2, 3, 4, 5, 1 };
        // int nums[] = { 1, 2, 3, 4, 5 };

        System.out.println(findMin(nums));
    }
}
