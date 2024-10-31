public class MergeSort {

    static void mergeSort(int arr[], int left, int right) {
        if (left >= right) {
            return;
        }

        int mid = (left + right) / 2;
        mergeSort(arr, left, mid);
        mergeSort(arr, mid + 1, right);
        merge(arr, left, mid, right);
    }

    static void merge(int[] arr, int left, int mid, int right) {
        int L = mid - left + 1;
        int R = right - mid;

        int[] leftArr = new int[L];
        int[] rightArr = new int[R];

        for (int i = 0; i < L; i++) {
            leftArr[i] = arr[left + i];
        }
        for (int j = 0; j < R; j++) {
            rightArr[j] = arr[mid + 1 + j];
        }

        int i = 0, j = 0;
        int k = left;
        while (i < L && j < R) {
            if (leftArr[i] <= rightArr[j]) {
                arr[k] = leftArr[i];
                i++;
            } else {
                arr[k] = rightArr[j];
                j++;
            }
            k++;
        }

        while (i < L) {
            arr[k] = leftArr[i];
            i++;
            k++;
        }

        while (j < R) {
            arr[k] = rightArr[j];
            j++;
            k++;
        }
    }

    public static void main(String[] args) {
        int[] arr = { 5, 2, 8, 1, 9 };
        int n = arr.length;
        mergeSort(arr, 0, n - 1);
        for (int i : arr) {
            System.out.println(i);
        }
    }
}