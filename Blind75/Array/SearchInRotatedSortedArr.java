// 33
// https://leetcode.com/problems/search-in-rotated-sorted-array/description/

public class SearchInRotatedSortedArr {

    static int search(int[] nums, int target) {
        int start = 0;
        int end = nums.length - 1;

        int pivot = findPivot(nums);

        if (target >= nums[pivot] && target <= nums[end]) {
            return binarySearch(nums, target, pivot, end);
        }

        return binarySearch(nums, target, start, pivot - 1);
    }

    static int findPivot(int[] nums) {
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

        return end;
    }

    static int binarySearch(int[] nums, int target, int start, int end) {
        while (start <= end) {
            int mid = start + (end - start) / 2;

            if (nums[mid] == target) {
                return mid;
            } else if (nums[mid] < target) {
                start = mid + 1;
            } else {
                end = mid - 1;
            }
        }

        return -1;
    }

    public static void main(String[] args) {
        int[] nums = { 4, 5, 6, 7, 0, 1, 2 };
        int target = 0;
        System.out.println(search(nums, target));
    }
}
