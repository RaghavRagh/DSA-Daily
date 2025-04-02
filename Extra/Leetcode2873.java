public class Leetcode2873 {

    private static long maximumTripletValue(int[] nums) {
        int n = nums.length;
        // long res = 0;
        // for (int k = 2; k < n; k++) {
        // int maxPrefix = nums[0];
        // for (int j = 1; j < k; j++) {
        // res = Math.max(res, (long) (maxPrefix - nums[j]) * nums[k]);
        // maxPrefix = Math.max(maxPrefix, nums[j]);
        // }
        // }

        long res = 0, imax = 0, dmax = 0;
        for (int k = 0; k < n; k++) {
            res = Math.max(res, dmax * nums[k]);
            dmax = Math.max(dmax, imax - nums[k]);
            imax = Math.max(imax, nums[k]);
        }

        return res;
    }

    public static void main(String[] args) {
        int[] nums = { 1, 10, 3, 4, 19 };
        System.out.println(maximumTripletValue(nums));
    }
}
