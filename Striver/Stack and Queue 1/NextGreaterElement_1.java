import java.util.HashMap;
import java.util.Stack;

public class NextGreaterElement_1 {
    // brute force
    // TC - O(n^2) 
    // SC - O(1)
    private static int[] nextGreaterElement1(int[] nums1, int[] nums2) {
        int[] res = new int[nums1.length];
        boolean found = false;

        for (int i = 0; i < nums1.length; i++) {
            found = false;
            for (int j = 0; j < nums2.length; j++) {
                if (nums1[i] == nums2[j]) {
                    found = true;
                }
                if (found && nums2[j] > nums1[i]) {
                    res[i] = nums2[j];
                    break;
                }
            }
        }

        for (int i = 0; i < res.length; i++) {
            if (res[i] == 0) {
                res[i] = -1;
            }
        }

        return res;
    }

    // brute force bit improved
    // TC - O(n^2)
    // SC - O(n)
    private static int[] nextGreaterElement2(int[] nums1, int[] nums2) {
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

        for (int i = 0; i < res.length; i++) {
            if (res[i] == 0) {
                res[i] = -1;
            }
        }

        return res;
    }

    // TC - O(n)
    private static int[] nextGreaterElement3(int[] nums1, int[] nums2) {
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
        int[] nums1 = { 4, 1, 2 };
        int[] nums2 = { 1, 3, 4, 2 };
        // int[] ans1 = nextGreaterElement1(nums1, nums2);
        // int[] ans2 = nextGreaterElement2(nums1, nums2);
        int[] ans3 = nextGreaterElement3(nums1, nums2);

        for (int i : ans3) {
            System.out.print(i + " ");
        }
        System.out.println();
    }
}
