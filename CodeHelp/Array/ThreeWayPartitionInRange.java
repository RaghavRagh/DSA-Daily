public class ThreeWayPartitionInRange {

    private static void threeWayPartition(int[] arr, int a, int b) {
        int start = 0, end = arr.length - 1;

        for (int i = 0; i <= end; i++) {
            if (arr[i] < a) {
                int temp = arr[i];
                arr[i] = arr[start];
                arr[start] = temp;
                start++;
            } else if (arr[i] > b) {
                int temp = arr[i];
                arr[i] = arr[end];
                arr[end] = temp;
                end--;
                i--;
            }
        }
    }
    
    public static void main(String[] args) {
        int[] arr = { 2, 5, 87, 56, 12, 4, 9, 23, 76, 1, 45 };
        int a = 15, b = 30;
        threeWayPartition(arr, a, b);
        for (int i : arr) {
            System.out.print(i + " ");
        }
    }
}
