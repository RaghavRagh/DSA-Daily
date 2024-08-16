import java.util.Arrays;

public class MinSwapGroupAll1Together {

    private static int minSwaps(int[] nums) {
        int totalOnes = Arrays.stream(nums).sum();

        int n = nums.length;
        if (totalOnes == 0 || totalOnes == n) {
            return 0;
        }

        int maxOnesInWindow = 0;
        int currentOneCount = 0;

        for (int i = 0; i < totalOnes; i++) {
            currentOneCount += nums[i];
        }

        maxOnesInWindow = currentOneCount;

        for (int i = 1; i < n; i++) {
            // remove the element going out of the window
            if (nums[(i - 1) % n] == 1) {
                currentOneCount--;
            }

            // add the new element coming into the window
            if (nums[(i + totalOnes - 1) % n] == 1) {
                currentOneCount++;
            }

            maxOnesInWindow = Math.max(maxOnesInWindow, currentOneCount);
        }

        return totalOnes - maxOnesInWindow;
    }

    public static void main(String[] args) {
        int[] nums = { 0, 1, 0, 1, 1, 0, 0 };
        System.out.println(minSwaps(nums));
    }
}