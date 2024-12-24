/*
 * Imagine array in 2 parts (sorted and unsorted)
 * Start with the first element in the list (index 0). This will be the current position where the smallest (or largest) element will   be placed.
 * Find the minimum element in the unsorted portion of the list. The unsorted portion starts from the current position and extends to the end of the list.
 * Swap the found minimum element with the element at the current position.
 * Move the current position to the next element.
 */

public class SelectionSort {

    private static void selectionSort(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            int smallest = i;
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[j] < arr[smallest]) {
                    smallest = j;
                }
            }

            int temp = arr[smallest];
            arr[smallest] = arr[i];
            arr[i] = temp;
        }
    }

    public static void main(String[] args) {
        int[] arr = { 5, 8, 6, 1, 0, 2 };
        selectionSort(arr);
        for (int i : arr) {
            System.out.print(i + " ");
        }
    }
}
