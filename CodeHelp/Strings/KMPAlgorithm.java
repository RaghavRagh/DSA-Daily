public class KMPAlgorithm {
    
    private static int[] computeLPS(String pattern) {
        int[] lps = new int[pattern.length()];
        int j = 0;

        for (int i = 1; i < pattern.length(); i++) {
            while (j > 0 && pattern.charAt(i) != pattern.charAt(j)) {
                j = lps[j - 1];
            }

            if (pattern.charAt(i) == pattern.charAt(j)) {
                j++;
            }

            lps[i] = j;
        }

        return lps;
    }
    
    private static boolean areRotations(String text, String pattern) {
        String s1 = text + text;
        String s2 = pattern;

        int[] lps = computeLPS(pattern);
        int i = 0, j = 0;

        while (i < s1.length()) {
            if (s2.charAt(j) == s1.charAt(i)) {
                i++;
                j++;
            }

            if (j == pattern.length()) {
                return true;
            } else if (i < s1.length() && s2.charAt(j) != s1.charAt(i)) {
                if (j != 0) {
                    j = lps[j - 1];
                } else {
                    i = i + 1;
                }
            }
        }

        return false;
    }   

    public static void main(String[] args) {
        String text = "abcd";
        String pattern = "cdab";
        System.out.println(areRotations(text, pattern));
    }
}
