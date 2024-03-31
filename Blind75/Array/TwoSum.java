// 1
// https://leetcode.com/problems/two-sum/description/
import java.util.HashMap;

public class TwoSum {

    private static int[] getIndexes(int[] nums, int target) {
        HashMap<Integer, Integer> map = new HashMap<>();
        int i = 0;

        while (i < nums.length) {
            int j = target - nums[i];
            if (map.containsKey(j)) {
                return new int[] { map.get(j), i };
            }

            map.put(nums[i], i);
            i++;
        }

        return new int[] { -1, -1 };
    }

    public static void main(String[] args) {
        int[] nums = { 11, 15, 7, 2 };
        int target = 9;
        int ans[] = getIndexes(nums, target);
        for (int i : ans) {
            System.out.print(i + " ");
        }
    }
}
