import java.util.Stack;

public class TrappingRainWater {

    private static int maxWater1(int[] height) {
        int totalWater = 0;
        for (int i = 1; i < height.length; i++) {
            int leftTallest = 0;
            for (int left = i; left >= 0; left--) {
                leftTallest = Math.max(leftTallest, height[left]);
            }

            int rightTallest = 0;
            for (int right = i; right < height.length; right++) {
                rightTallest = Math.max(rightTallest, height[right]);
            }

            totalWater += Math.min(leftTallest, rightTallest) - height[i];
        }

        return totalWater;
    }

    private static int maxWater2(int[] height) {
        Stack<Integer> s = new Stack<>();
        int n = height.length;
        int totalWater = 0;

        for (int i = 0; i < n; i++) {
            while (!s.isEmpty() && height[i] > height[s.peek()]) {
                int bottom = s.pop();
                if (s.isEmpty())
                    break;
                int left = s.peek();
                int width = i - left - 1;
                int heightWater = Math.min(height[left], height[i]) - height[bottom];
                totalWater += width * heightWater;
            }

            s.push(i);
        }

        return totalWater;
    }

    public static void main(String[] args) {
        int[] height = { 3, 0, 1, 0, 4, 0, 2 };
        System.out.println(maxWater2(height));
    }
}
/*
 * 1. Initialize Variables:
 *      Use a stack to store indices of the bars.
 *      Keep a variable to track the total water trapped.
 * 
 * 2. Iterate Through the Array:
 *      For each bar at index i:
 *          * If the stack is empty: Push the index onto the stack (no valley can form
 *              yet).
 *          * If the stack is not empty and the current height (height[i]) is greater than
 *              the height at the top of the stack:
 *              * This means a valley is formed.
 *              * Pop the stack to get the "bottom" of the valley.
 * 
 * 3. Check for Boundaries:
 *      * After popping, if the stack becomes empty, there is no left boundary, so no
 *      water is trapped for this valley.
 *      * Otherwise:
 *          * The current bar at i serves as the right boundary.
 *          * The new top of the stack serves as the left boundary.
 * 
 * 4. Calculate Trapped Water:
 *      Width of the valley: Distance between the left and right boundaries.
 *      Height of the trapped water: min(left boundary, right boundary) - bottom.
 *      Add the trapped water to the total.
 * 
 * 5. Push the Current Bar:
 *      After processing the valley, push the current index onto the stack as a
 *      potential left boundary for future valleys.
 * 
 * 6. Repeat for All Bars:
 *      Continue processing until all bars are checked.
 */