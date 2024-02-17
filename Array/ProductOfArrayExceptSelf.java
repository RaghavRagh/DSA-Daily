// 238
// https://leetcode.com/problems/product-of-array-except-self/description/

public class ProductOfArrayExceptSelf {

    //Approach 1
    static int[] productExceptSelf(int[] nums) {
        int n = nums.length;
        int arrLeft[] = new int[n];
        int arrRight[] = new int[n];

        arrLeft[0] = 1;
        for (int i = 1; i < arrLeft.length; i++) {
            arrLeft[i] = arrLeft[i - 1] * nums[i - 1];
        }

        arrRight[n - 1] = 1;
        for (int i = n - 2; i >= 0; i--) {
            arrRight[i] = arrRight[i + 1] * nums[i + 1];
        }

        int result[] = new int[n];
        for (int i = 0; i < result.length; i++) {
            result[i] = arrLeft[i] * arrRight[i];
        }

        return result;
    }

    //Approach 2    
    static int[] productExceptSelf2(int[] nums) {
        int prefix = 1;
        int result[] = new int[nums.length];

        for (int i = 0; i < nums.length; ++i) {
            result[i] = prefix;
            prefix = prefix * nums[i];
        }

        prefix = 1;
        for (int i = nums.length - 1; i >= 0; --i) {
            result[i] = result[i] * prefix;
            prefix = prefix * nums[i];
        }
        
        return result;
    }

    public static void main(String[] args) {
        int[] nums = { 1, 2, 3, 4 };
        // int[] nums = { -1, 1, 0, -3, 3 };

        int[] result1 = productExceptSelf(nums);
        for (int i : result1) {
            System.out.print(i + " ");
        }

        // int[] result2 = productExceptSelf2(nums);
        // for (int i : result2) {
        //     System.out.print(i + " ");
        // }
    }
}
