import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class ChocolateDistributionProb {

    private static int findMinDiff(ArrayList<Integer> list, int m) {
        if (list.size() < m) {
            return 0;
        }

        Collections.sort(list);
        int i = 0, j = m - 1, minDiff = Integer.MAX_VALUE;
        while (j < list.size()) {
            minDiff = Math.min(minDiff, list.get(j) - list.get(i));
            i++;
            j++;
        }

        return minDiff;
    }

    public static void main(String[] args) {
        ArrayList<Integer> list = new ArrayList<>(Arrays.asList(3, 4, 1, 9, 56, 7, 9, 12));
        int m = 5;
        System.out.println(findMinDiff(list, m));
    }
}
