import java.util.Arrays;
import java.util.Stack;

public class NextGreaterElement_2 {

    private static int[] nextGreaterElements(int[] nums) {
        Stack<Integer> s = new Stack<>();
        int n = nums.length;
        int[] res = new int[nums.length];
        Arrays.fill(res, -1);

        for (int i = 0; i < 2 * n; i++) {
            int num = nums[i % n];
            while (!s.empty() && nums[s.peek()] < num) {
                res[s.pop()] = num;
            }

            if (i < n) {
                s.push(i);
            }
        }

        // for (int i = (2 * n) - 1; i >= 0; i--) {
        //     System.out.println("i % n = " + (i % n));
        //     while (!s.empty() && s.peek() <= nums[i % n]) {
        //         s.pop();
        //     }
        //
        //     if (i < n) {
        //         if (!s.empty()) {
        //             res[i] = s.peek();
        //         } else {
        //             res[i] = -1;
        //         }
        //     }
        //
        //     s.push(nums[i % n]);
        // }

        return res;
    }
    
    public static void main(String[] args) {
        int[] nums = { 1, 2, 3, 4, 3 }; 
        int[] ans = nextGreaterElements(nums);

        for (int i : ans) {
            System.out.print(i + " ");
        }
        System.out.println();
    }
}
