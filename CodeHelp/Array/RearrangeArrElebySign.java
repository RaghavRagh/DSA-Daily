public class RearrangeArrElebySign {

    private static int[] rearrange(int[] nums) {
        int[] ans = new int[nums.length];
        int i = 0, j = 0, k = 0;

        while (i < nums.length && j < nums.length) {
            while (i < nums.length && nums[i] < 0) {
                i++;
            }

            while (j < nums.length && nums[j] >= 0) {
                j++;
            }

            if (k < ans.length) {
                ans[k++] = nums[i++];
            }
            if (k < ans.length) {
                ans[k++] = nums[j++];
            }
        }

        return ans;
    }

    public static void main(String[] args) {
        int[] nums = { 9, 4, -2, -1, 5, 0, -5, -3, 2 };
        int[] ans = rearrange(nums);
        for (int i : ans) {
            System.out.print(i + " ");
        }
    }
}
