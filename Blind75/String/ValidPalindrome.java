public class ValidPalindrome {

    public boolean isPalindrome(String s) {
        s = s.toLowerCase();
        if (s.isEmpty()) {
            return true;
        }

        int start = 0;
        int end = s.length() - 1;

        while (start < end) {
            if (!Character.isLetterOrDigit(s.charAt(start))) {
                start++;
            } else if (!Character.isLetterOrDigit(s.charAt(end))) {
                end--;
            } else {
                if (s.charAt(start) != s.charAt(end)) {
                    return false;
                }

                start++;
                end--;
            }
        }

        return true;
    }

    public static void main(String[] args) {
        ValidPalindrome v = new ValidPalindrome();
        String s = "A man, a plan, a canal: Panama";
        boolean ans = v.isPalindrome(s);
        System.out.println(ans);
    }
}