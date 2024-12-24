public class MinimumJumps {

    private static int minJumps(int[] nums) {
        int jumps = 0, currentEnd = 0, farthest = 0;

        for (int i = 0; i < nums.length - 1; i++) {
            farthest = Math.max(farthest, i + nums[i]);

            // If we've reached the end of the current jump range
            if (i == currentEnd) {
                jumps++;
                currentEnd = farthest;
                // If the farthest point doesn't advance, return -1
                if (currentEnd <= i) {
                    return -1;
                }
            }
        }

        return jumps;
    }

    public static void main(String[] args) {
        int[] arr = { 1, 2, 0, 0, 5 };
        System.out.println(minJumps(arr));
    }
}
