import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class InsertInterval {

    static int[][] insert(int[][] intervals, int[] newInterval) {
        List<int[]> list = new ArrayList<>();
        Arrays.sort(intervals, Comparator.comparingInt(i -> i[0]));

        for(int inter[] : intervals) {
            if (inter[1] < newInterval[0]) {
                list.add(inter);
            } else if (newInterval[1] < inter[0]) {
                list.add(newInterval);
                newInterval = inter;
            } else {
                newInterval[0] = Math.min(newInterval[0], inter[0]);
                newInterval[1] = Math.max(newInterval[1], inter[1]);
            }
        }

        list.add(newInterval);

        return  list.toArray(new int[list.size()][]);
    }

    public static void main(String[] args) {
        // int[][] intervals = { { 1, 3 }, { 6, 9 } };
        int[][] intervals = { { 1, 2 }, { 3, 5 }, { 6, 7 }, { 8, 10 }, { 12, 16 } };
        int[] newInterval = { 4, 8 };
        int[][] ans = insert(intervals, newInterval);
        for (int[] i : ans) {
            for (int j : i) {
                System.out.print(j + " ");
            }
            System.out.println();
        }
    }
}