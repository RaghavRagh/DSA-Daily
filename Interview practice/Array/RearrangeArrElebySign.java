public class RearrangeArrElebySign {

    private static int[] rearrangeArray(int[] nums) {
        int n = nums.length;
        int[] res = new int[n];
        int i = 0, j = 0, k = 0;

        while (i < n && j < n) {
            while (nums[i] < 0) {
                i++;
            }

            while (nums[j] > 0) {
                j++;
            }

            res[k++] = nums[i++];
            res[k++] = nums[j++];
        }

        return res;
    }

    public static void main(String[] args) {
        int[] nums = { 3, 1, -2, -5, 2, -4 };
        int[] res = rearrangeArray(nums);
        for (int i : res) {
            System.out.print(i + " ");
        }
    }
}
