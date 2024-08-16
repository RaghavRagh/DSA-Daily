import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CombinationSum2 {

    private static List<List<Integer>> combinationSum2(int[] nums, int target) {
        List<List<Integer>> res = new ArrayList<>();
        Arrays.sort(nums);
        solve(nums, target, 0, new ArrayList<>(), res);
        return res;
    }

    private static void solve(int[] nums, int target, int index, List<Integer> list, List<List<Integer>> res) {
        if (target == 0) {
            res.add(new ArrayList<>(list));
            return;
        }

        for (int i = index; i < nums.length; i++) {
            if(i > index && nums[i] == nums[i - 1]) continue;
            if (nums[index] > target) break;

            list.add(nums[i]);
            solve(nums, target - nums[i], i + 1, list, res);
            list.remove(list.size() - 1);
        }
    }
    
    public static void main(String[] args) {
        int[] nums = { 10, 1, 2, 7, 6, 1, 5 };
        int target = 8;
        List<List<Integer>> list = combinationSum2(nums, target);
        System.out.println(list);
    }
}
