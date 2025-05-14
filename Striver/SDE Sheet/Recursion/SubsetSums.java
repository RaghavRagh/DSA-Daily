import java.util.ArrayList;

public class SubsetSums {

    private static ArrayList<Integer> subsetSums(ArrayList<Integer> arr) {
        ArrayList<Integer> ans = new ArrayList<>();
        ArrayList<Integer> sumList = new ArrayList<>();
        solve(arr, 0, sumList, ans);
        return ans;
    }

    private static void solve(ArrayList<Integer> arr, int index, ArrayList<Integer> sumList, ArrayList<Integer> ans) {
        // base case
        if (index >= arr.size()) {
            int sum = 0;
            for (int i : sumList) {
                sum += i;
            }
            ans.add(sum);
            return;
        }

        // exclude
        solve(arr, index + 1, sumList, ans);

        // include
        int element = arr.get(index);
        sumList.add(element);
        solve(arr, index + 1, new ArrayList<>(sumList), ans);
        sumList.remove(sumList.size() - 1);
    }

    public static void main(String[] args) {
        ArrayList<Integer> arr = new ArrayList<>();
        arr.add(2);
        arr.add(3);
        ArrayList<Integer> ans = new ArrayList<>(subsetSums(arr));
        System.out.println(ans);
    }
}
