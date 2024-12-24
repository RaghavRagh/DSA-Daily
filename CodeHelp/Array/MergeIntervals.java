import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class MergeIntervals {

    // Approach 1 
    // TC - O(n^2)
    private static List<List<Integer>> merge1(int[][] intervals) {

        Arrays.sort(intervals, (int[] a, int[] b) -> {
            return a[0] - b[0];
        });

        List<List<Integer>> list = new ArrayList<>();

        for (int i = 0; i < intervals.length; i++) {
            int start = intervals[i][0];
            int end = intervals[i][1];

            if (!list.isEmpty() && end <= list.get(list.size() - 1).get(1)) {
                continue;
            }

            for (int j = i + 1; j < intervals.length; j++) {
                if (intervals[j][0] <= end) {
                    end = Math.max(end, intervals[j][1]);
                } else {
                    break;
                }
            }

            list.add(Arrays.asList(start, end));
        }

        return list;
    }

    // Approach 2
    // TC - O(nlogn)
    // SC - O(n)
    private static int[][] merge2(int[][] intervals) {
        if (intervals.length <= 1) {
            return intervals;
        }

        Arrays.sort(intervals, Comparator.comparingInt(i -> i[0]));

        List<int[]> ans = new ArrayList<>();

        int[] newInterval = intervals[0];
        ans.add(newInterval);

        for (int inter[] : intervals) {
            if (inter[0] <= newInterval[1]) {
                newInterval[1] = Math.max(newInterval[1], inter[1]);
            } else {
                newInterval = inter;
                ans.add(newInterval);
            }
        }

        return ans.toArray(new int[ans.size()][]);
    }

    public static void main(String[] args) {
        // int[][] arr = { { 1, 3 }, { 2, 6 }, { 8, 10 }, { 15, 18 } };
        int[][] arr = { { 1, 5 }, { 2, 4 }, { 8, 10 }, { 15, 18 } };
        List<List<Integer>> list = merge1(arr);
        // list.forEach(System.out::print);

        merge2(arr);
    }
}
