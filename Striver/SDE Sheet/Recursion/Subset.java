import java.util.ArrayList;
import java.util.List;

public class Subset {

    // private static List<List<Integer>> subsets(int[] nums) {
    //     List<List<Integer>> ans = new ArrayList<>();
    //     List<Integer> output = new ArrayList<>();
    //     solve(nums, 0, output, ans);
    //     return ans;
    // }

    // private static void solve(int[] nums, int index, List<Integer> output, List<List<Integer>> ans) {
    //     if (index >= nums.length) {
    //         ans.add(new ArrayList<>(output));
    //         return;
    //     }

    //     // exclude
    //     solve(nums, index + 1, output, ans);

    //     // include
    //     int element = nums[index];
    //     output.add(element);
    //     solve(nums, index + 1, new ArrayList<>(output), ans);
    //     output.remove(output.size() - 1);
    // }

    public static List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        generateSets(nums, 0, new ArrayList<>(), ans);
        return ans;
    }

    private static void generateSets(int[] nums, int index, List<Integer> current, List<List<Integer>> ans) {

        if(index == nums.length) {
            ans.add(new ArrayList<>(current));
            return;
        }

        current.add(nums[index]);
        generateSets(nums, index + 1, current, ans);

        current.remove(current.size() - 1);
        generateSets(nums, index + 1, current, ans);
    }

    public static void main(String[] args) {
        int[] nums = { 1, 2, 3 };
        List<List<Integer>> ans = new ArrayList<>(subsets(nums));
        System.out.println(ans);
    }
}