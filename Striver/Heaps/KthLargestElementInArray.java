public class KthLargestElementInArray {

    public static void heapify(int[] nums, int n, int i) {
        int largest = i;
        int leftChild = 2 * i + 1;
        int rightChild = 2 * i + 2;

        if (leftChild < n && nums[leftChild] > nums[largest]) {
            largest = leftChild;
        }

        if (rightChild < n && nums[rightChild] > nums[largest]) {
            largest = rightChild;
        }

        if (largest != i) {
            swap(nums, largest, i);
            heapify(nums, n, largest);
        }
    }

    public static void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

    public static int findKthLargest(int[] nums, int k) {
        int n = nums.length;
        for (int i = n / 2 - 1; i >= 0; i--) {
            heapify(nums, n, i);
        }

        for (int i = 0; i < k - 1; i++) {
            swap(nums, 0, n - 1 - i);
            heapify(nums, n - 1 - i, 0);
        }

        return nums[0];
    }

    public static void main(String[] args) {
        int[] nums = { 3, 2, 1, 5, 6, 4 };
        int k = 2;

        int ans = findKthLargest(nums, k);
        System.out.println("Second largest element: " + ans);
    }
}
