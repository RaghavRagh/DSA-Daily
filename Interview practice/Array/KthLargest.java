import java.util.PriorityQueue;

public class KthLargest {

    private static int kthLargest(int[] arr, int k) {
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();

        for (int i = 0; i < k; i++) {
            minHeap.offer(arr[i]);
        }

        for (int i = k; i < arr.length; i++) {
            if (arr[i] > minHeap.peek()) {
                minHeap.poll();
                minHeap.offer(arr[i]);
            }
        }

        return minHeap.peek();
    }

    public static void main(String[] args) {
        int[] arr = { 10, 3, 7, 6 };
        System.out.println(kthLargest(arr, 3));
    }
}
