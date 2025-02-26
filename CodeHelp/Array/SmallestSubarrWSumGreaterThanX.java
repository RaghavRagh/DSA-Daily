public class SmallestSubarrWSumGreaterThanX {

    private static int smallestSubWithSum(int[] arr, int x) {
        int minDiff = Integer.MAX_VALUE;
        int start = 0, sum = 0;

        for (int end = 0; end < arr.length; end++) {
            sum += arr[end];
            while (sum > x) {
                minDiff = Math.min(minDiff, end - start + 1);
                sum -= arr[start++];
            }
        }

        return minDiff == Integer.MAX_VALUE ? 0 : minDiff;
    }
    
    public static void main(String[] args) {
        int[] arr = { 1, 4, 45, 6, 0, 19 };
        int x = 51;
        System.out.println(smallestSubWithSum(arr, x));
    }
}
