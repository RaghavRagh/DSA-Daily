import java.util.ArrayList;
import java.util.List;
import java.util.TreeMap;

public class RankTransformOfAnArray {

    private static int[] arrayRankTransform(int[] arr) {
        TreeMap<Integer, List<Integer>> numToIndices = new TreeMap<>();

        for (int i = 0; i < arr.length; i++) {
            if (!numToIndices.containsKey(arr[i])) {
                numToIndices.put(arr[i], new ArrayList<>());
            }
            numToIndices.get(arr[i]).add(i);
        }

        int rank = 1;
        for (int num : numToIndices.keySet()) {
            for (int index : numToIndices.get(num)) {
                arr[index] = rank;
            }
            rank++;
        }

        return arr;
    }

    public static void main(String[] args) {
        int[] arr = { 40, 10, 10, 30, 10 };
        int[] res = arrayRankTransform(arr);
        for (int i : res) {
            System.out.print(i + " ");
        }
    }
}
