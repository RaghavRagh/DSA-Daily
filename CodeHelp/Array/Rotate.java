public class Rotate {

    private static void rotate(int[] arr) {
        int n = arr.length;
        swap(arr, 0, n - 1);
        swap(arr, 1, n - 1);
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
        rotate(arr);
        for (int i : arr) {
            System.out.print(i + " ");
        }
    }
}
