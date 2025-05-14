import java.util.HashSet;

public class Q1 {
    
    public static int palindrome(String s) {
        if (s.length() == 1) {
            return 1;
        }
        
        HashSet<String> set = new HashSet<>();
        
        for (int i = 0; i < s.length(); i++) {
            for (int j = i + 1; j <= s.length(); j++) {
                String subStr = s.substring(i, j);
                if (isPalindrome(subStr) && !set.contains(subStr)) {
                    set.add(subStr);
                }
            }
        }
        
        return set.size();
    }
    
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
        System.out.println(palindrome("aabaa"));
    }
}
