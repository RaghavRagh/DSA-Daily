import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class InsertInterval {

    static int[][] insert(int[][] intervals, int[] newInterval) {
        int n = intervals.length, i = 0;
        List<int[]> res = new ArrayList<>();

        // Case 1: No overlapping before merging intervals
        while (i < n && intervals[i][1] < newInterval[0]) {
            res.add(intervals[i]);
            i++;
        }

        // Case 2: Overlapping and merging intervals
        while (i < n && newInterval[1] >= intervals[i][0]) {
            newInterval[0] = Math.min(newInterval[0], intervals[i][0]);
            newInterval[1] = Math.max(newInterval[1], intervals[i][1]);
            i++;
        }
        res.add(newInterval);

        // Case 3: No overlapping after merging newInterval
        while (i < n) {
            res.add(intervals[i]);
            i++;
        }

        // Convert List to array
        return res.toArray(new int[res.size()][]);

        // List<int[]> list = new ArrayList<>();
        // Arrays.sort(intervals, Comparator.comparingInt(i -> i[0]));

        // for(int inter[] : intervals) {
        // // if curr inter is less than newInterval
        // if (inter[1] < newInterval[0]) {
        // list.add(inter);
        // }
        // // if newInterval is less than curr inter
        // else if (newInterval[1] < inter[0]) {
        // list.add(newInterval);
        // newInterval = inter;
        // }
        // // if newInterval is in range of curr inter
        // else {
        // newInterval[0] = Math.min(newInterval[0], inter[0]);
        // newInterval[1] = Math.max(newInterval[1], inter[1]);
        // }
        // }

        // list.add(newInterval);

        // return list.toArray(new int[list.size()][]);        
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