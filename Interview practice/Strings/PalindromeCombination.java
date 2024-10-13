import java.util.HashSet;

public class PalindromeCombination {
    
    public static boolean canFormPalindrome(String a, String b) {
        HashSet<String> substrings = new HashSet<>();
        
        // Generate all substrings of a
        for (int i = 0; i < a.length(); i++) {
            for (int j = i + 1; j <= a.length(); j++) {
                substrings.add(a.substring(i, j));
            }
        }
        
        // Check if any substring from b can form a palindrome with substrings from a
        for (String subB : getAllSubstrings(b)) {
            for (String subA : substrings) {
                if (isPalindrome(subA + subB) || isPalindrome(subB + subA)) {
                    return true;
                }
            }
        }
        
        return false;
    }

    private static HashSet<String> getAllSubstrings(String str) {
        HashSet<String> substrings = new HashSet<>();
        for (int i = 0; i < str.length(); i++) {
            for (int j = i + 1; j <= str.length(); j++) {
                substrings.add(str.substring(i, j));
            }
        }
        return substrings;
    }

    private static boolean isPalindrome(String str) {
        int left = 0, right = str.length() - 1;
        while (left < right) {
            if (str.charAt(left) != str.charAt(right)) {
                return false;
            }
            left++;
            right--;
        }
        return true;
    }

    public static void main(String[] args) {
        String a = "abca";
        String b = "xyzzy";
        
        boolean result = canFormPalindrome(a, b);
        System.out.println("Can form palindrome: " + result);
    }
}

