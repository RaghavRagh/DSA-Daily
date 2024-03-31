public class InversionCount {

    private static int divide(int[] arr, int start, int end) {

        int count = 0;

        if (start < end) {
            int mid = start + (end - start) / 2;
            count += divide(arr, start, mid);
            count += divide(arr, mid + 1, end);
            count += solve(arr, start, mid, end);
        }

        return count;
    }

    private static int solve(int[] arr, int start, int mid, int end) {
        int inversion = 0;
        int len1 = mid - start + 1;
        int len2 = end - mid;

        int[] left = new int[len1];
        int[] right = new int[len2];

        for (int i = 0; i < len1; i++) {
            left[i] = arr[start + i];
        }

        for (int i = 0; i < len2; i++) {
            right[i] = arr[mid + 1 + i];
        }

        int i = 0; int j = 0;
        int k = start;

        while (i < len1 && j < len2) {
            if (left[i] <= right[j]) {
                arr[k++] = left[i++];
            } else {
                arr[k++] = right[j++];
                inversion += len1 - i;
            }
        }

        while (i < len1) {
            arr[k++] = left[i++];
        }

        while (j < len2) {
            arr[k++] = right[j++];
        }

        return inversion;
    }

    public static void main(String[] args) {
        int[] arr = { 5, 3, 2, 4, 1 };
        int count = divide(arr, 0, arr.length - 1);
        System.out.println(count);
    }
}
