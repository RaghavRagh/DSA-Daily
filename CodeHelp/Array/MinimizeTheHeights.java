// https://www.geeksforgeeks.org/problems/minimize-the-heights3351/1

import java.util.Arrays;

public class MinimizeTheHeights {

    private static int getMinDiff(int[] arr, int n, int k) {
        Arrays.sort(arr);
        int min = arr[0];
        int max = arr[n - 1];
        int res = max - min;

        for (int i = 1; i < n; i++) {
            max = Math.max(arr[i - 1] + k, arr[n - 1] - k);
            min = Math.min(arr[0] + k, arr[i] - k);
            res = Math.min(res, max - min);
        }

        return res;
    }

    public static void main(String[] args) {
        int[] arr = { 1, 5, 8, 10 };
        int n = arr.length;
        int res = getMinDiff(arr, n, 2);
        System.out.println(res);
    }
}
