import java.util.Arrays;

public class MinNumofRemovalsToMakeMountainArr {

    private static int minimumMountainRemovals(int[] nums) {
        int n = nums.length;
        int[] lisDp = new int[n];
        int[] ldsDp = new int[n];

        Arrays.fill(lisDp, 1);
        Arrays.fill(ldsDp, 1);

        for (int i = 1; i < n; i++) {
            for (int j = 0; j < i; j++) {
                if (nums[j] < nums[i]) {
                    lisDp[i] = Math.max(lisDp[i], lisDp[j] + 1);
                }
            }
        }

        for (int i = n - 2; i >= 0; i--) {
            for (int j = n - 1; j > i; j--) {
                if (nums[j] < nums[i]) {
                    ldsDp[i] = Math.max(ldsDp[i], ldsDp[j] + 1);
                }
            }
        }

        int maxMountainLen = 0;
        for (int i = 1; i < n - 1; i++) {
            if (lisDp[i] > 1 && ldsDp[i] > 1) {
                maxMountainLen = Math.max(maxMountainLen, lisDp[i] + ldsDp[i] - 1);
            }
        }
        
        return n - maxMountainLen;
    }

    public static void main(String[] args) {
        int[] nums = { 2, 1, 1, 5, 6, 2, 3, 1 };
        System.out.println(minimumMountainRemovals(nums));
    }
}
