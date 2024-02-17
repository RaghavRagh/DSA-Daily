// 11
// https://leetcode.com/problems/container-with-most-water/description/

public class ContainerWMostWater {

    private static int maxArea(int[] height) {
        int left = 0;
        int right = height.length - 1;

        int max = 0;
        while (left < right) {
            int leftHeight = height[left];
            int rightHeight = height[right];

            int minHeight = Math.min(leftHeight, rightHeight);
            max = Math.max(max, minHeight * (right - left));

            if (leftHeight < rightHeight) {
                left++;
            } else {
                right--;
            }
        }

        return max;
    }

    public static void main(String[] args) {
        int[] height = { 1, 8, 6, 2, 5, 4, 8, 3, 7 };
        int area = maxArea(height);
        System.out.println(area);
    }
}