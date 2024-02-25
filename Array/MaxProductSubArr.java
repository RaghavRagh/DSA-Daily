// 152
// https://leetcode.com/problems/maximum-product-subarray/description/

import java.util.ArrayList;

public class MaxProductSubArr {

    static int maxProduct(int[] nums) {
        int prod1 = nums[0];
        int prod2 = nums[0];
        int result = nums[0];

        for (int i = 1; i < nums.length; i++) {
            int temp = Math.max(nums[i], Math.max(prod1 * nums[i], prod2 * nums[i]));
            prod2 = Math.min(nums[i], Math.min(prod1 * nums[i], prod2 * nums[i]));
            prod1 = temp;

            result = Math.max(result, prod1);
        }

        return result;
    }

    public static void main(String[] args) {
        int[] arr = { 2, 3, -2, 4, 7, 8, 5, 6, 7 };
        ArrayList<Integer> list = new ArrayList<>(5);
        for (int i = 0; i < arr.length; i++) {
            list.add(arr[i]);
        }

        for (int i = 0; i < arr.length; i++) {
            System.out.print(list.get(i) + " ");
        }

        // int result = maxProduct(arr);
        // System.out.println(result);
    }
}
