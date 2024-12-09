import java.util.Arrays;

public class MinimizetheHeightsII {

    private static int getMinDiff(int[] arr, int k) {
        int n = arr.length;
        Arrays.sort(arr);
        int max = 0, min = 0;
        int ans = arr[n - 1] - arr[0];
        int smallest = arr[0], largest = arr[n - 1];
        
        for (int i = 0; i < n - 1; i++) {
            min = Math.min(smallest + k, arr[i + 1] - k);
            max = Math.max(largest - k, arr[i] + k);
            if (min < 0) {  
                continue;
            }
            ans = Math.min(ans, max - min);
        }

        return ans;
    }

    public static void main(String[] args) {
        int[] arr = { 1, 5, 8, 10 };
        int k = 2;
        System.out.println(getMinDiff(arr, k));
    }
}
