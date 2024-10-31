import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class LongestSquareStreakInArr {

    private static int longestSquareStreak(int[] nums) {
        Set<Integer> set = new HashSet<>();
        Arrays.stream(nums).forEach(set::add);
        int maxStreak = 0;

        for (int num : nums) {
            int count = 0;
            long curr = num;

            while (set.contains((int) curr)) {
                count++;
                if (curr * curr > 1e5) break;
                curr *= curr;
            }

            maxStreak = Math.max(maxStreak, count);
        }

        return maxStreak < 2 ? -1 : maxStreak;
    }

    public static void main(String[] args) {
        int[] nums = { 4, 3, 6, 16, 8, 2 };
        System.out.println(longestSquareStreak(nums));
    }
}
