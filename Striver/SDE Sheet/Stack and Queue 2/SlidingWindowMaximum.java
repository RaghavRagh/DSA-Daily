import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.PriorityQueue;

public class SlidingWindowMaximum {

    // TC - O(nlogk)
    private static int[] maxSlidingWindow1(int[] nums, int k) {
        ArrayList<Integer> list = new ArrayList<>();
        PriorityQueue<Integer> q = new PriorityQueue<>((a, b) -> b - a);
        int i = 0;

        for (; i < k; i++) {
            q.add(nums[i]);
        }

        // adding maximum element among first k elements
        list.add(q.peek());

        q.remove(nums[0]);

        for (; i < nums.length; i++) {
            q.add(nums[i]);
            list.add(q.peek());
            q.remove(nums[i - k + 1]);
        }

        int[] ans = new int[list.size()];
        for (int j = 0; j < list.size(); j++) {
            ans[j] = list.get(j);
        }

        return ans;
    }

    // TC - O(n)
    // SC - O(k)
    private static int[] maxSlidingWindow2(int[] nums, int k) {
        int n = nums.length;
        int[] ans = new int[n - k + 1];
        int ri = 0;
        Deque<Integer> dq = new ArrayDeque<>();

        for (int i = 0; i < nums.length; i++) {
            // remove numbers out of range of k
            if (!dq.isEmpty() && dq.peek() == i - k) {
                dq.poll();
            }

            // remove smaller numbers in k range as they are useless
            while (!dq.isEmpty() && nums[dq.peekLast()] < nums[i]) {
                dq.pollLast();
            }

            dq.offer(i);
            if (i >= k - 1) {
                ans[ri++] = nums[dq.peek()];
            }
        }

        return ans;

        // Deque<Integer> dq = new ArrayDeque<>();
        // ArrayList<Integer> list = new ArrayList<>();
        //
        // int i;
        // for (i = 0; i < k; i++) {
        // while (!dq.isEmpty() && nums[dq.peekLast()] <= nums[i]) {
        // dq.removeLast();
        // }
        // dq.addLast(i);
        // }
        //
        // // process rest of the elements
        // // i.e from k to [n - 1]
        // for (; i < nums.length; i++) {
        // list.add(nums[dq.peek()]);
        //
        // // remove the element which are out this window
        // while (!dq.isEmpty() && dq.peek() <= i - k) {
        // dq.removeFirst();
        // }
        //
        // // remove all elements smaller than the currently
        // // being added element (remove useless elements)
        // while (!dq.isEmpty() && nums[i] >= nums[dq.peekLast()]) {
        // dq.removeLast();
        // }
        //
        // dq.addLast(i);
        // }
        //
        // list.add(dq.peek());
        //
        // int[] ans = new int[list.size()];
        // for (int j = 0; j < list.size(); j++) {
        // ans[j] = list.get(j);
        // }
        //
        // return ans;
    }

    public static void main(String[] args) {
        int[] nums = { 1, 3, -1, -3, 5, 3, 6, 7 };
        int k = 3;
        int res[] = maxSlidingWindow1(nums, k);

        res = maxSlidingWindow2(nums, k);
        for (int i : res) {
            System.out.print(i + " ");
        }
    }
}