public class SubarraySumEqualsK {

    static int subarraySum(int[] nums, int k) {
        int left = 0;
        int right = 0;
        int subArr = 0;
        int sum = 0;

        while (right < nums.length) {
            sum += nums[right];

            if (sum == k) {
                subArr++;
            }
            
            if (sum > k) {
                while (left <= right && sum > k) {
                    sum -= nums[left];
                    left++;
                }

                if (sum == k) {
                    subArr++;
                }
            }

            right++;
        }

        return subArr;
    }

    public static void main(String[] args) {
        int nums[] = { 1, 1, 1 };
        System.out.println(subarraySum(nums, 2));
    }
}
