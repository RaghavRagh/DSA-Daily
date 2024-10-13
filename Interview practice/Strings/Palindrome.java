public class Palindrome {

    private static boolean isPalindrome(String s) {
        int i = 0, j = s.length() - 1;
        while (i < j) {
            if (s.charAt(i++) != s.charAt(j--)) {
                return false;
            }
        }

        return true;
    }
    
    public static void main(String[] args) {
        String s = "aabaa";
        System.out.println(isPalindrome(s));
    }
}