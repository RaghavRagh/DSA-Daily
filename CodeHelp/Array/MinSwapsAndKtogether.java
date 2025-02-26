import java.util.Arrays;

public class MinSwapsAndKtogether {

    private static int minSwap(int[] arr, int k) {
        int window = (int) Arrays.stream(arr).filter(x -> x <= k).count();
        int start = 0, end = window - 1, minSwaps = Integer.MAX_VALUE;
        while (end < arr.length) {
            int count = 0;
            for (int i = start; i < start + window; i++) {
                if (arr[i] <= k) {
                    count++;
                }
            }
            start++; end++;
            minSwaps = Math.min(minSwaps, window - count);
        }
        
        return minSwaps;
    }

    public static void main(String[] args) {
        int[] arr = { 2, 7, 9, 5, 8, 7, 4 };
        int k = 6;
        System.out.println(minSwap(arr, k));
    }
}