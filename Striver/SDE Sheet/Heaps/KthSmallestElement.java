import java.util.PriorityQueue;

public class KthSmallestElement {
    
    private static int kthSmallest(int[]arr, int K) {
        PriorityQueue<Integer> pq = new PriorityQueue<>((a, b) -> b - a);

        for (int i = 0; i < arr.length; i++) {
            pq.offer(arr[i]);

            if (pq.size() > K) {
                pq.poll();
            }
        }

        return pq.peek();
    }
    
    public static void main(String[] args) {
        int[] arr = { 10, 5, 4, 3, 48, 6, 2, 33, 53, 10 };
        int K = 2;
        System.out.println("Kth Smallest Element is: " + kthSmallest(arr, K));
    }
}
