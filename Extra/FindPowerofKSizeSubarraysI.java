// public class FindPowerofKSizeSubarraysI {

//     private static int[] resultsArray(int[] nums, int k) {
//         int n = nums.length;
//         int[] res = new int[n - k + 1];

//         for (int i = 0; i <= n - k; i++) {
//             boolean isConsecutive = true;
//             int maxElement = nums[i];
            
//             for (int j = i; j < i + k - 1; j++) {
//                 if (nums[j] + 1 != nums[j + 1]) {
//                     isConsecutive = false;
//                     break;
//                 }
//                 maxElement = Math.max(maxElement, nums[j + 1]);
//             }

//             if (isConsecutive) {
//                 res[i] = maxElement;
//             } else {
//                 res[i] = -1;
//             }
//         }

//         return res;
//     }

//     public static void main(String[] args) {
//         int[] nums = { 1, 2, 3, 4, 3, 2, 5 };
//         int k = 3;
//         int[] res = resultsArray(nums, k);
//         for (int i : res) {
//             System.out.print(i + " ");
//         }
//     }
// }

public class FindPowerofKSizeSubarraysI {

    private static int[] resultsArray(int[] nums, int k) {
        int n = nums.length;
        int[] res = new int[n - k + 1];

        for (int i = 0; i <= n - k; i++) {
            int maxElement = nums[i];
            int minElement = nums[i];

            boolean isConsecutive = true;

            for (int j = i; j < i + k; j++) {
                if (nums[j] > maxElement) {
                    maxElement = nums[j];
                }
                if (nums[j] < minElement) {
                    minElement = nums[j];
                }

                if (j > i && nums[j] != nums[j - 1] + 1) {
                    isConsecutive = false;
                }
            }

            if (isConsecutive && (maxElement - minElement == k - 1)) {
                res[i] = maxElement;
            } else {
                res[i] = -1;
            }
        }

        return res;
    }

    public static void main(String[] args) {
        int[] nums = { 1, 2, 3, 4, 3, 2, 5 };
        int k = 3;
        int[] res = resultsArray(nums, k);
        for (int i : res) {
            System.out.print(i + " ");
        }
    }
}
