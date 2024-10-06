public class MaximumSubArrProduct {

    public static int maxSubArrayProduct(int[] nums) {
        int pre = 1, suff = 1;
        int res = Integer.MIN_VALUE;

        for (int i = 0; i < nums.length; i++) {
            if (pre == 0) {
                pre = 1;
            }

            if (suff == 0) {
                suff = 1;
            }
            
            pre = pre * nums[i];
            suff = suff * nums[nums.length - 1 - i];
            res = Math.max(res, Math.max(pre, suff));
        }

        return res;
    }

    public static void main(String[] args) {
        int[] arr = { 2, 3, -2, 4 };
        System.out.println(maxSubArrayProduct(arr));
    }
}
