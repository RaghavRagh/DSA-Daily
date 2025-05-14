import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class LongestConsecutiveSequence {

    static int longestConsecutive2(int[] nums) {
        if (nums.length == 0) {
            return 0;
        }

        Set<Integer> set = new HashSet<>();
        int longest = 1;
        for (int num: nums) {
            set.add(num);
        }

        for (int i : set) {
            if (!set.contains(i - 1)) {
                int count = 1;
                int x = i;
                while (set.contains(x + 1)) {
                    x++;
                    count++;
                }

                longest = Math.max(count, longest);
            }
        }

        return longest;
    }
    
    // TC - O(nlogn)
    static int longestConsecutive1(int[] nums) {
        if (nums.length == 0) {
            return 0;
        }
        Arrays.sort(nums);

        int lastSmaller = Integer.MIN_VALUE;
        int count = 0;
        int longest = 1;

        for (int i = 0; i < nums.length; i++) {
            if (nums[i] - 1 == lastSmaller) {
                count++;
                lastSmaller = nums[i];
            }
            else if (nums[i] != lastSmaller) {
                count = 1;
                lastSmaller = nums[i];
            }

            longest = Math.max(longest, count);
        }
        
        return longest;
    }

    public static void main(String[] args) {
        int[] arr = { 0, 3, 7, 2, 5, 8, 4, 6, 0, 1 };
        // System.out.println(longestConsecutive1(arr));
        System.out.println(longestConsecutive2(arr));
        // longestConsecutive(arr);
    }
}
