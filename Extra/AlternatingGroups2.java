import java.util.Arrays;

public class AlternatingGroups2 {

    // TC - O(n + k)
    // SC - O(k)
    private static int numberOfAlternatingGroups(int[] colors, int k) {
        int[] arr = Arrays.copyOf(colors, colors.length + k - 1);
        for (int i = 0; i < k - 1; i++) {
            arr[colors.length + i] = colors[i];
        }

        int length = arr.length, result = 0, left = 0, right = 1;
            while (right < length) {
            if (arr[right] == arr[right - 1]) {
                left = right++;
                continue;
            }

            right++;
            if (right - left < k) continue;
            result++;
            left++;
        }

        return result;
    }

    public static void main(String[] args) {
        int[] colors = { 0, 1, 0, 0, 1, 0, 1 };
        System.out.println(numberOfAlternatingGroups(colors, 6));
    }
}
