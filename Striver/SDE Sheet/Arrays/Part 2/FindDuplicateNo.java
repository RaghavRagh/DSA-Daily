// https://leetcode.com/problems/find-the-duplicate-number/description/

public class FindDuplicateNo {

    // Approach 1
    // TC - O(n)
    private int findDuplicate1(int[] nums) {
        int len = nums.length;
        for (int num : nums) {
            int idx = Math.abs(num);
            if (nums[idx] < 0) {
                return idx;
            }
            nums[idx] = -nums[idx];
        }

        return len;
    }

    // Approach 2
    // TC - O(n)
    private int findDuplicate2(int[] nums) {
        // start slow and fast pointer
        // until they meet
        int slow = 0;
        int fast = 0;

        do {
            slow = nums[slow];
            fast = nums[nums[fast]];
        } while (slow != fast);

        // as soon as they meet, move both pointers
        // at same speed until they meet again
        slow = 0;
        while (slow != fast) {
            slow = nums[slow];
            fast = nums[fast];
        }

        return slow;
    }

    public static void main(String[] args) {
        int[] nums1 = { 4, 5, 8, 6, 7, 4, 3, 2, 1 };

        FindDuplicateNo f = new FindDuplicateNo();
        int ans = f.findDuplicate1(nums1);
        System.out.println(ans);

        // int ans2 = f.findDuplicate2(nums1);
        // System.out.println(ans2);
    }
}
