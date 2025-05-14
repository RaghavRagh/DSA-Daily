public class LongestPalindromicSubstring {

    // TC - O(n^2)
    private static String longestPalindrome1(String s) {
        if (s.length() <= 1) {
            return s;
        }

        int maxLength = 0;
        String ans = "";

        for (int i = 0; i < s.length(); i++) {
            String oddPalindrome = expandAroundCenter(s, i, i);
            if (oddPalindrome.length() > maxLength) {
                maxLength = oddPalindrome.length();
                ans = oddPalindrome;
            }

            if (i + 1 < s.length()) {
                String evenPalindrome = expandAroundCenter(s, i, i + 1);
                if (evenPalindrome.length() > maxLength) {
                    maxLength = evenPalindrome.length();
                    ans = evenPalindrome;
                }
            }
        }

        return ans;
    }

    private static String expandAroundCenter(String s, int i, int j) {
        while (i >= 0 && j < s.length() && s.charAt(i) == s.charAt(j)) {
            i--;
            j++;
        }

        return s.substring(i + 1, j);
    }

    // TC - O(n)
    private static String longestPalindrome2(String s) {
        if (s == null || s.length() < 1)
            return "";

        StringBuilder t = new StringBuilder();
        t.append('#');
        for (char c : s.toCharArray()) {
            t.append(c);
            t.append('#');
        }

        char[] tArray = t.toString().toCharArray();
        int n = tArray.length;

        int[] p = new int[n];
        int center = 0, right = 0;
        int maxLength = 0, maxCenter = 0;

        for (int i = 0; i < n; i++) {
            int mirror = 2 * center - i;

            if (i < right) {
                p[i] = Math.min(right - i, p[mirror]);
            }

            while (i + p[i] + 1 < n && i - p[i] - 1 >= 0 && tArray[i + p[i] + 1] == tArray[i - p[i] - 1]) {
                p[i]++;
            }

            if (i + p[i] > right) {
                center = i;
                right = i + p[i];
            }
            
            if (p[i] > maxLength) {
                maxLength = p[i];
                maxCenter = i;
            }
        }

        int start = (maxCenter - maxLength) / 2;
        return s.substring(start, start + maxLength);
    }

    public static void main(String[] args) {
        String s = "ababc";
        System.out.println(longestPalindrome1(s));
        System.out.println(longestPalindrome2(s));
    }
}
