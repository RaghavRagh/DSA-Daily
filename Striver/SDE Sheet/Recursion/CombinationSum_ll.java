import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CombinationSum_ll {

    private static List<List<Integer>> combinationSum2(int[] candidates, int target) {
        Arrays.sort(candidates);
        List<List<Integer>> ans = new ArrayList<>();
        int sum = 0;
        solve(candidates, target, 0, new ArrayList<>(), ans, sum);
        return ans;
    }

    // private static void solve(int[] arr, int target, int index, List<Integer> list, List<List<Integer>> ans) {
    //     if (target == 0) {
    //         ans.add(new ArrayList<>(list));
    //     }

    //     for (int i = index; i < arr.length; i++) {
    //         if (i > index && arr[i] == arr[i - 1]) {
    //             continue;
    //         }
    //         if (arr[index] > target) {
    //             break;
    //         }
    //         list.add(arr[i]);
    //         solve(arr, target - arr[i], i + 1, list, ans);
    //         list.remove(list.size() - 1);
    //     }
    // }

    private static void solve(int[] arr, int target, int index, List<Integer> list, List<List<Integer>> ans, int sum) {
        if (sum == target) {
            ans.add(new ArrayList<>(list));
            return;
        }

        if (sum > target || index == arr.length) {
            return;
        } 

        // pick the element
        list.add(arr[index]);
        sum += arr[index];
        solve(arr, target, index + 1, list, ans, sum);
        // backtrack
        list.remove(list.size() - 1);
        sum -= arr[index];

        // not pick the element also check no duplicates should be there
        while (index < arr.length - 1 && arr[index] == arr[index + 1]) {
            index++;
        }

        solve(arr, target, index + 1, list, ans, sum);
    }

    public static void main(String[] args) {
        int[] candidates = { 2, 5, 2, 1, 2 };
        int target = 5;
        List<List<Integer>> ans = new ArrayList<>(combinationSum2(candidates, target));
        System.out.println(ans);
    }
}
