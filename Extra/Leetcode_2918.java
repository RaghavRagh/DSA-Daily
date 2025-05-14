import java.util.Arrays;

public class Leetcode_2918 {

    private static long minSum(int[] nums1, int[] nums2) {
        long sum1 = Arrays.stream(nums1).asLongStream().sum();
        long sum2 = Arrays.stream(nums2).asLongStream().sum();
        long zero1 = Arrays.stream(nums1).filter(x -> x == 0).count();
        long zero2 = Arrays.stream(nums2).filter(x -> x == 0).count();
        sum1 += zero1;
        sum2 += zero2;

        if ((zero1 == 0 && sum1 < sum2) || (zero2 == 0 && sum1 > sum2)) {
            return -1;
        }

        return Math.max(sum1, sum2);
    }


    public static void main(String[] args) {
        int[] nums1 = { 3, 2, 0, 1, 0 }, nums2 = { 6, 5, 0 };
        System.out.println(minSum(nums1, nums2));
    }
}
