/*
 * Start with the second element (since a single element is trivially sorted).
 * Compare it with the element before it.
 * If the element is smaller, shift the previous elements to the right.
 * Insert the element in its correct position.
 */

public class InsertionSort {
    
    private static void insertionSort(int[] arr) {
        for (int i = 1; i < arr.length; i++) {
            int curr = arr[i];
            int prev = i - 1;
            while (prev >= 0 && arr[prev] > curr) {
                arr[prev + 1] = arr[prev];
                prev--;    
            }

            arr[prev + 1] = curr;
        }
    }
    
    public static void main(String[] args) {
        int[] arr = { 5, 8, 6, 1, 0, 2 };
        insertionSort(arr);
        for (int i : arr) {
            System.out.print(i + " ");
        }
    }
}
