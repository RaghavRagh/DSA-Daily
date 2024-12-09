public class JumpGame_1 {

    private static boolean canJump(int[] nums) {
        int finalPos = nums.length - 1;

        for (int i = nums.length - 2; i >= 0; i--) {
            if (i + nums[i] >= finalPos) {
                finalPos = i;
            }
        }

        return finalPos == 0;
    }
    
    public static void main(String[] args) {
        int[] nums = { 3, 2, 1, 0, 1 };
        // index       0, 1, 2, 3, 4
        System.out.println(canJump(nums));
    }
}
