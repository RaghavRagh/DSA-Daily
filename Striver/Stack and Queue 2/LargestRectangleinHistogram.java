import java.util.Stack;

public class LargestRectangleinHistogram {

    // brute force
    // take every rectange in a histogram
    // for each height/length check left/right-height/length till the checking
    // height is >= left/right height.
    // cal area using (height * (left + right + 1)) and store it in max
    // update max if new max greater > current max.
    // return max

    // TC - O(n^2)
    // SC - O(1)
    private static int largestRectangleArea1(int[] heights) {
        int maxArea = 0;

        for (int i = 0; i < heights.length; i++) {
            int height = heights[i];
            int left = 0;
            for (int j = i - 1; j >= 0; j--) {
                if (heights[j] >= height) {
                    left++;
                } else {
                    break;
                }
            }

            int right = 0;
            for (int j = i + 1; j < heights.length; j++) {
                if (heights[j] >= height) {
                    right++;
                } else {
                    break;
                }
            }

            int area = height * (left + right + 1);
            maxArea = Math.max(maxArea, area);
        }

        return maxArea;
    }

    // TC - O(n)
    // SC - O(n)
    private static int largestRectangleArea2(int[] heights) {
        int maxArea = 0;
        int n = heights.length;
        Stack<Integer> stack = new Stack<>();

        for (int i = 0; i <= n; i++) {
            int currentHeight = (i == n) ? 0 : heights[i];
            while (!stack.isEmpty() && currentHeight < heights[stack.peek()]) {
                int height = heights[stack.pop()];
                int width = stack.isEmpty() ? i : i - stack.peek() - 1;
                maxArea = Math.max(maxArea, height * width);
            }
            stack.push(i);
        }

        return maxArea;
    }

    public static void main(String[] args) {
        // int[] heights = { 2, 1, 5, 6, 2, 3, 1, 1, 1, 1, 1 };
        // 0, 1, 2, 3, 4, 5
        int[] heights = {1, 3, 5, 2, 3 };
        System.out.println(largestRectangleArea2(heights));
    }
}
