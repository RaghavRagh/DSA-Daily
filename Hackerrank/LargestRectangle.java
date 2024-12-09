import java.util.Arrays;
import java.util.List;
import java.util.Stack;

public class LargestRectangle {

    // TC - O(n^2)
    private static long largestReactangle(List<Integer> h) {
        long maxArea = 0;
        for (int i = 0; i < h.size(); i++) {
            int left = i - 1, right = i + 1;
            while (left >= 0 && h.get(left) >= h.get(i)) {
                left--;
            }
            
            while (right < h.size() && h.get(right) >= h.get(i)) {
                right++;
            }
            
            int area = h.get(i) * (right - left - 1);
            maxArea = Math.max(maxArea, area);
        }
        
        return maxArea;
    }
    
    // TC - O(n) SC - O(n)
    private static long largestReactangle2(List<Integer> h) {
        int maxArea = 0;
        Stack<Integer> s = new Stack<>();

        for (int i = 0; i < h.size(); i++) {
            
        }

        return maxArea;
    }
    
    public static void main(String[] args) {
        List<Integer> h = Arrays.asList(1, 2, 3, 4, 5);
        System.out.println(largestReactangle2(h));
    }
}