import java.util.Arrays;

public class Leetcode2962 {

    // TC - O(n)
    private static long countSubarrays(int[] nums, int k) {
        int maxElement = Arrays.stream(nums).max().getAsInt();
        int start = 0, maxElementsInWin = 0;
        long ans = 0;

        for (int end = 0; end < nums.length; end++) {
            if (nums[end] == maxElement) {
                maxElementsInWin++;
            }

            while (maxElementsInWin == k) {
                if (nums[start] == maxElement) {
                    maxElementsInWin--;
                }
                start++;
            }

            ans += start;
        }

        return ans;
    }
    
    public static void main(String[] args) {
        int[] nums = { 1, 3, 2, 3, 3 };
        System.out.println(countSubarrays(nums, 3));
    }
}
