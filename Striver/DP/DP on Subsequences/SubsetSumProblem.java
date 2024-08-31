import java.util.Arrays;

public class SubsetSumProblem {

    private static boolean isSubsetSum(int n, int[] arr, int sum) {
        return solve(arr, sum, 0, n);
    }

    private static boolean solve(int[] arr, int sum, int index, int n) {
        if (sum < 0 || index >= n) {
            return false;
        }

        if (sum == 0 && index < n) {
            return true;
        }

        return solve(arr, sum - arr[index], index + 1, n) || solve(arr, sum, index + 1, n);
    }

    public static void main(String[] args) {
        int[] arr = { 3, 34, 4, 12, 5, 3 };
        int sum = 8;
        System.out.println(isSubsetSum(arr.length, arr, sum));
    }
}