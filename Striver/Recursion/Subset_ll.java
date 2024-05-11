import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Subset_ll {

    // private static List<List<Integer>> subsetsWithDup(int[] nums) {
    //     List<List<Integer>> ans = new ArrayList<>();
    //     Arrays.sort(nums);
    //     solve(nums, 0, new ArrayList<>(), ans);
    //     return ans;
    // }
    //
    // private static void solve(int[] nums, int index, ArrayList<Integer> list, List<List<Integer>> ans) {
    //     if (!ans.contains(list)) {
    //         ans.add(new ArrayList<>(list));
    //     }
    //
    //     for (int i = index; i < nums.length; i++) {
    //         list.add(nums[i]);
    //         solve(nums, i + 1, list, ans);
    //         list.remove(list.size() - 1);
    //     }
    // }
    
    private static List<List<Integer>> subsetsWithDup(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        Arrays.sort(nums);
        solve(nums, 0, new ArrayList<>(), ans);
        return ans;
    }

    private static void solve(int[] nums, int index, List<Integer> list, List<List<Integer>> ans) {
        ans.add(new ArrayList<>(list));

        for (int i = index; i < nums.length; i++) {
            if (i != index && nums[i] == nums[i - 1]) {
                continue;
            }

            list.add(nums[i]);
            solve(nums, i + 1, list, ans);
            list.remove(list.size() - 1);
        }
    }
    
    public static void main(String[] args) {
        int nums[] = { 1, 2, 2 };
        List<List<Integer>> list = new ArrayList<>(subsetsWithDup(nums));
        System.out.println(list);
    }
}
