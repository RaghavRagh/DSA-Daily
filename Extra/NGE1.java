import java.util.Arrays;
import java.util.HashMap;
import java.util.Stack;

public class NGE1 {

    // O(n * m)
    private static int[] nextGreaterElement(int[] nums1, int[] nums2) {
        int[] res = new int[nums1.length];
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums2.length; i++) {
            map.put(nums2[i], i);
        }

        for (int i = 0; i < nums1.length; i++) {
            for (int j = map.get(nums1[i]); j < nums2.length; j++) {
                if (nums2[j] > nums1[i]) {
                    res[i] = nums2[j];
                    break;
                }
            }
        }

        res = Arrays.stream(res).map(x -> x == 0 ? -1 : x).toArray();
        return res;
    }

    // O(n + m)
    private static int[] nextGreaterElement2(int[] nums1, int[] nums2) {
        int[] res = new int[nums1.length];
        Stack<Integer> s = new Stack<>();
        HashMap<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i < nums2.length; i++) {
            while (!s.isEmpty() && s.peek() < nums2[i]) {
                map.put(s.pop(), nums2[i]);
            }

            s.push(nums2[i]);
        }

        for (int i : s) {
            map.put(i, -1);
        }

        for (int i = 0; i < nums1.length; i++) {
            res[i] = map.get(nums1[i]);
        }

        return res;
    }

    public static void main(String[] args) {
        int[] nums1 = { 4, 1, 2 }, nums2 = { 1, 3, 4, 2 };
        int[] ans = nextGreaterElement2(nums1, nums2);
        for (int i : ans) {
            System.out.print(i + " ");
        }
    }
}
