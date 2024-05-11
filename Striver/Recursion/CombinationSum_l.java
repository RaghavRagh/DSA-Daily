import java.util.ArrayList;
import java.util.List;

public class CombinationSum_l {

    private static List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> ans = new ArrayList<>();
        solve(candidates, target, 0, new ArrayList<>(), ans);
        return ans;
    }

    private static void solve(int[] arr, int target, int index, List<Integer> list, List<List<Integer>> ans) {
        if (index >= arr.length) {
            if (target == 0) {
                ans.add(new ArrayList<>(list));
            }
            return;
        }
        
        //include
        if (arr[index] <= target) { 
            list.add(arr[index]);
            solve(arr, target - arr[index], index, list, ans);
            list.remove(list.size() - 1);
        }

        //exclude
        solve(arr, target, index + 1, list, ans);
    }

    public static void main(String[] args) {
        int[] candidates = { 2, 3, 6, 7 };
        int target = 7;
        List<List<Integer>> ans = new ArrayList<>(combinationSum(candidates, target));
        System.out.println(ans);
    }
}
