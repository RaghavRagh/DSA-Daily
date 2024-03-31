public class Sort012 {

    static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    // Approach 1

    static void sort012(int[] arr) {
        int low = 0;
        int mid = 0;
        int high = arr.length - 1;

        while (mid <= high) {
            switch (arr[mid]) {
                case 0: {
                    swap(arr, low, mid);
                    low++;
                    mid++;
                    break;
                }
                case 1: {
                    mid++;
                    break;
                }
                case 2: {
                    swap(arr, mid, high);
                    high--;
                    break;
                }
            }
        }
    }

    // Approach 2

    public static void main(String[] args) {
        int[] arr = {2, 0, 2, 1, 1, 0};
        sort012(arr);
        for(int i: arr) {
            System.out.print(i + " ");
        }
    }
}
