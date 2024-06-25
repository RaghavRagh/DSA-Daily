import java.util.Arrays;

public class RelativeSortArray {

    private static int[] relativeSortArray(int[] arr1, int[] arr2) {
        int length = Arrays.stream(arr1).max().getAsInt();
        int[] count = new int[length + 1];

        for (int i : arr1) {
            count[i]++;
        }

        int[] ans = new int[arr1.length];
        int index = 0;
        for (int i : arr2) {
            while (count[i] > 0) {
                ans[index++] = i;
                count[i]--;
            }
        }

        for (int i = 0; i < count.length; i++) {
            while (count[i] > 0) {
                ans[index++] = i;
                count[i]--;
            }
        }

        return ans;
    }

    public static void main(String[] args) {
        int[] arr1 = { 2, 3, 1, 3, 2, 4, 6, 7, 9, 2, 19 };
        int[] arr2 = { 2, 1, 4, 3, 9, 6 };

        int[] ans =  relativeSortArray(arr1, arr2);

        for (int i : ans) {
        System.out.print(i + " ");
        }
    }
}