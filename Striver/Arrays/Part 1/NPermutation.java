public class NPermutation {

    private static void nextPermutation(int[] nums) {
        int n = nums.length;
        int idx = -1;

        // finding brek point
        for (int i = n - 2; i >= 0; i--) {
            if (nums[i] < nums[i + 1]) {
                idx = i;
                break;
            }
        }

        // if i == -1 reverse whole array and return 
        if (idx == -1) {
            int i = 0;
            int j = n - 1;
            while (i < j) {
                swap(nums, i, j);
                i++; j--;
            }

            return;
        }

        // find next small small no. from (break point + 1) to (n - 1)
        // and swap it with idx
        for (int i = n - 1; i > idx; i--) {
            if (nums[i] > nums[idx]) {
                swap(nums, idx, i);
                break;
            }
        }

        // reverse array from idx to n - 1 and return
        int i = idx + 1;
        int j = n - 1;
        while (i < j) {
            swap(nums, i, j);
            i++; j--;
        }

        return;
    }

    private static void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

    public static void main(String[] args) {
        int[] nums = { 5, 4, 7, 5, 3, 2 };
        nextPermutation(nums);
        for (int i : nums) {
            System.out.print(i + " ");
        }
    }
}
