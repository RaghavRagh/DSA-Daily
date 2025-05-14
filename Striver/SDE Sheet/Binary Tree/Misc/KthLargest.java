import java.util.PriorityQueue;

public class KthLargest {

    PriorityQueue<Integer> pq;
    int k;

    public KthLargest (int[] nums, int k) {
        pq = new PriorityQueue<>();
        this.k = k;

        for (int i : nums) {
            add(i);
        }
    }

    public int add(int val) {
        pq.offer(val);
        if (pq.size() > k) {
            pq.poll();
        }

        return pq.peek();
    }
    
    public static void main(String[] args) {
        int[] nums = {4,5,8,2};
        int k = 3;
        KthLargest obj = new KthLargest(nums, k);
        System.out.println(obj.add(3));
        System.out.println(obj.add(5));
        System.out.println(obj.add(10));
    }
}