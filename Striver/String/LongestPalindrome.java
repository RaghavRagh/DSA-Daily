import java.util.HashSet;

public class LongestPalindrome {

    private static int longestPalindrome(String s) {

        HashSet<Character> set = new HashSet<>();
        int length = 0;

        for (char ch : s.toCharArray()) {
            if (set.contains(ch)) {
                set.remove(ch);
                length += 2;
            } else {
                set.add(ch);
            }
        }

        if (!set.isEmpty()) {
            length += 1;
        }

        return length;

        // int[] arr = new int[58];
        // int count = 0, odd = 0;

        // for (char each : s.toCharArray()) {
        // arr[each - 'A']++;
        // }

        // for (int each : arr) {
        // if (each % 2 == 0 && each != 0) {
        // count += each;
        // } else if (each % 2 == 1 && each != 1) {
        // count += each - 1;
        // odd = 1;
        // } else if (each == 1) {
        // odd = 1;
        // }
        // }

        // return count + odd;
    }

    public static void main(String[] args) {
        String s = "abccccab";
        System.out.println(longestPalindrome(s));
    }
}
