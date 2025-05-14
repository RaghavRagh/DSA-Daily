import java.util.ArrayList;
import java.util.List;

public class PalindromePartitioning {

    private static List<List<String>> partition(String s) {
        List<List<String>> ans = new ArrayList<>();
        partition(s, 0, new ArrayList<>(), ans);
        return ans;
    }

    private static void partition(String s, int index, List<String> list, List<List<String>> ans) {
        if(index >= s.length()) {
            ans.add(new ArrayList<>(list));
            return;
        }

        for (int i = index; i < s.length(); i++) {
            if (isPalindrome(s, index , i)) {
                list.add(s.substring(index, i + 1));
                partition(s, i + 1, list, ans);
                list.remove(list.size() - 1);
            }
        }
    }

    private static boolean isPalindrome(String s, int start, int end) {
        while (start <= end) {
            if (s.charAt(start++) != s.charAt(end--)) {
                return false;
            }
        }

        return true;
    }   

    public static void main(String[] args) {
        String s = "aab";
        List<List<String>> ans = new ArrayList<>(partition(s)); 
        System.out.println(ans);
    }
}
