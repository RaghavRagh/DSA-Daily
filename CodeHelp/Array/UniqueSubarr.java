import java.util.ArrayList;
import java.util.List;

public class UniqueSubarr {

    private static int findUniqueSubArr(int[] arr, int k) {
        if (arr.length < k) return 0;
        List<List<Integer>> combs = new ArrayList<>();
        generateCombination(arr, 0, new ArrayList<>(), k, combs);

        int count = 0;
        for (List<Integer> list : combs) {
            if (isIncreasing(list)) {
                count++;
            }
        }

        return count;
    }

    private static void generateCombination(int[] arr, int start, List<Integer> temp, int k, List<List<Integer>> res) {
        if (temp.size() == k) {
            res.add(new ArrayList<>(temp));
            return;
        }

        for (int i = start; i < arr.length; i++) {
            temp.add(arr[i]);
            generateCombination(arr, i + 1, temp, k, res);
            temp.remove(temp.size() - 1);
        }
    }

    private static boolean isIncreasing(List<Integer> list) {
        for (int i = 1; i < list.size(); i++) {
            if (list.get(i - 1) >= list.get(i)) {
                return false;
            }
        }

        return true;
    }
    
    public static void main(String[] args) {
        int[] arr = { 1, 2, 3, 4, 5 };
        int k = 3;
        System.out.println(findUniqueSubArr(arr, k));
    }
}
