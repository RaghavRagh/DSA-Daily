import java.util.HashSet;

public class LongestCommonSequence {

    private static int longestConsecutive(int[] arr) {
        HashSet<Integer> set = new HashSet<>();
        for (int i : arr) {
            set.add(i);
        }
        int maxLength = 1;

        for (int i : arr) {
            int longest = 0;
            if (!set.contains(i - 1)) {
                while (set.contains(i)) {
                    longest++;
                    i++;
                }
            }

            maxLength = Math.max(maxLength, longest);
        }

        return maxLength;
    }

    public static void main(String[] args) {
        int[] arr = { 2, 6, 1, 9, 4, 5, 3 };
        System.out.println(longestConsecutive(arr));
    }
}
