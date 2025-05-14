public class Leetcode930 {

    private static int numSubarraysWithSum(int[] nums, int goal) {
        int count = 0, start = 0, sum = 0;
        for (int end = 0; end < nums.length; end++) {
            sum += nums[end];
            if (sum == goal) {
                count++;
            }
            
            while (sum > goal) {
                sum -= nums[start];
                if (sum == goal) count++;
                start++;
            }
        }

        return count;
    }
    
    public static void main(String[] args) {
        int[] nums = { 1, 0, 1, 0, 1 };
        System.out.println(numSubarraysWithSum(nums, 2));
    }
}
