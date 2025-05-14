public class ReversePairs {

    static int reversePairs(int[] nums) {
        return merge(nums, 0, nums.length - 1);
    }

    static int merge(int[] nums, int low, int high) {
        int count = 0;

        if (low < high) {
            int mid = low + (high - low) / 2;
            count += merge(nums, low, mid);
            count += merge(nums, mid + 1, high);
            count += countPairs(nums, low, mid, high);
            solve(nums, low, mid, high);
        }

        return count;
    }

    static int countPairs(int[] nums, int low, int mid, int high) {
        int right = mid + 1;
        int count = 0;

        for (int i = low; i <= mid; i++) {
            while (right <= high && nums[i] > 2 * nums[right]) {
                right++;
                count += (right - (mid + 1));
            }
        }

        return count;
    }

    static void solve(int[] nums, int low, int mid, int high) {
        int m = mid - low + 1;
        int n = high - mid;

        int[] left = new int[m];
        int[] right = new int[n];

        for (int i = 0; i < m; i++) {
            left[i] = nums[low + i];
        }

        for (int i = 0; i < n; i++) {
            right[i] = nums[mid + 1 + i];
        }

        int i = 0, j = 0;
        int k = low;

        while (i < m && j < n) {
            if (left[i] <= right[j]) {
                nums[k++] = left[i++];
            } else {
                nums[k++] = right[j++];
            }
        }

        while (i < m) {
            nums[k++] = left[i++];
        }

        while (j < n) {
            nums[k++] = right[j++];
        }
    }

    public static void main(String[] args) {
        int[] nums = { 2, 4, 3, 5, 1 };
        int ans = reversePairs(nums);
        System.out.println(ans);
    }
}
