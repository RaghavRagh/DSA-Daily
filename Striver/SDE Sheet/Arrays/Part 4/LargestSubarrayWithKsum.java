import java.util.HashMap;

public class LargestSubarrayWithKsum {

    static int maxLen(int[] nums, int n) {
        int left = 0;
        int right = 0;
        int maxLength = 0;
        int sum = 0;

        while (right < nums.length) {
            sum += nums[right];

            if (sum == n) {
                int tempLen = right - left + 1;
                maxLength = Math.max(maxLength, tempLen);
            }

            if (sum > n) {
                while (left <= right && sum > n) {
                    sum -= nums[left];
                    left++;
                }
            }

            right++;
        }

        return maxLength;
    }

    // from geeks for geeks
    static void subArrWZeroSum(int[] nums) {
        HashMap<Integer, Integer> map = new HashMap<>();
        int max = 0;
        int sum = 0;

        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];

            if (sum == 0) {
                max = i + 1;
            } else {
                if (map.get(sum) != null) {
                    max = Math.max(max, i - map.get(sum));
                } else {
                    map.put(sum, i);
                }
            }
        }

        System.out.println(max);
    }

    public static void main(String[] args) {
        int[] nums = { 15, -2, 2, -8, 1, 7, 10, 23 };
        // System.out.println(maxLen(nums, 0));
        subArrWZeroSum(nums);
    }
}
