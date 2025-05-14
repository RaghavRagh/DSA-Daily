import java.util.Arrays;

public class AggresiveCows {

    private static int calMaxDistance(int[] arr, int k) {
        Arrays.sort(arr);

        int s = 0;
        int e = arr[arr.length - 1];
        int ans = -1;

        while (s <= e) {
            int mid = s + (e - s) / 2;
            if (isPossible(arr, k, mid)) {
                ans = mid;
                s = mid + 1;
            } else {
                e = mid - 1;
            }
        }

        return ans;
    }

    private static boolean isPossible(int[] arr, int k, int mid) {
        int cowCount = 1;
        int lastPos = arr[0];

        for (int i : arr) {
            if (i - lastPos >= mid) {
                cowCount++;
                if (cowCount == k) {
                    return true;
                }
                lastPos = i;
            }
        }

        return false;
    }

    public static void main(String[] args) {
        int[] arr = { 4, 2, 1, 3, 6 };
        int k = 2;
        System.out.println(calMaxDistance(arr, k));
    }
}
