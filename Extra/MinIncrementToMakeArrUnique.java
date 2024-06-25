import java.util.Arrays;

public class MinIncrementToMakeArrUnique {

    private static int minIncrementUnique(int[] nums) {
        // int moves = 0;
        // Arrays.sort(nums);
        //
        // for (int i = 1; i < nums.length; i++) {
        //     while (nums[i] <= nums[i - 1]) {
        //         nums[i]++;
        //         moves++;
        //     }
        // }
        //
        // return moves;

        int n = nums.length;
        int minIncrement = 0;
        int max = Arrays.stream(nums).max().getAsInt();

        int[] frequencyCount = new int[max + n];
        for (int i : nums) {
            frequencyCount[i]++;
        }

        for (int i = 0; i < frequencyCount.length; i++) {
            if (frequencyCount[i] <= 1)
                continue;

            int duplicates = frequencyCount[i] - 1;
            frequencyCount[i + 1] += duplicates;
            frequencyCount[i] = 1;
            minIncrement += duplicates;
        }

        return minIncrement;
    }

    public static void main(String[] args) {
        int[] nums = { 3, 2, 1, 2, 1, 7 };
        System.out.println(minIncrementUnique(nums));
    }
}
