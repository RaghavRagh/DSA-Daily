public class LongestRepeatingSubseq {

    private static int lrs(String s) {
        String s2 = new String(s);
        return solve(s, s2, 0, 0);
    }

    private static int solve(String s1, String s2, int i, int j) {
        if (i >= s1.length() || j >= s2.length()) {
            return 0;
        }

        if (s1.charAt(i) == s1.charAt(j) && i != j) {
            return 1 + solve(s1, s2, i + 1, j + 1);
        } else {
            return Math.max(solve(s1, s2, i + 1, j), solve(s1, s2, i, j + 1));
        }
    }

    public static void main(String[] args) {
        String s = "AABB";
        System.out.println(lrs(s));
    }
}
