/*
 * In n-1 iteration
 * compare adjacent element
 * push larger one at last by swapping
 */

public class BubbleSort {

    private static void bubbleSort(int[] arr) {
        for (int i = 0; i < arr.length - 1; i++) {
            boolean isSwap = false;
            for (int j = 0; j < arr.length - i - 1; j++) {
                if (arr[j] > arr[j + 1]) {
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                    isSwap = true;
                }
            }
            if (!isSwap) {
                return;
            }
        }
    }

    public static void main(String[] args) {
        // int[] arr = { 2, 0, 2, 1, 1, 0 };
        int[] arr = { 1, 2, 4, 3, 5 };
        bubbleSort(arr);
        for (int i : arr) {
            System.out.print(i + " ");
        }
    }
}