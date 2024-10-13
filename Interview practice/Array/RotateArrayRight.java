public class RotateArrayRight {

    private static void rotateArr1(int[] arr, int n, int k) {
        k = k % n;
        int[] rotated = new int[n];

        for (int i = 0; i < n; i++) {
            if (i < k) {
                rotated[i] = arr[n + i - k];
            } else {
                rotated[i] = arr[i - k];
            }
        }
        System.arraycopy(rotated, 0, arr, 0, n);
    }

    private static void rotateArr2(int[] arr, int n, int k) {
        k = k % n;
        swap(arr, 0, n - 1);

        swap(arr, 0, k - 1);

        swap(arr, k, n - 1);
    }

    private static void swap(int[] arr, int i, int j) {
        while (i < j) {
            int temp = arr[i];
            arr[i++] = arr[j];
            arr[j--] = temp;
        }
    }

    public static void main(String[] args) {
        int[] arr = { 1, 2, 3, 4, 5 };
        // rotateArr1(arr, arr.length, 3);
        rotateArr2(arr, arr.length, 3);
        for (int i : arr) {
            System.out.print(i + " ");
        }
    }
}
