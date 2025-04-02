import java.util.ArrayList;
import java.util.List;

public class AllSubsequences {

    private static List<String> subsequences(String s) {
        List<String> res = new ArrayList<>();
        solve(s, 0, "", res);
        return res;
    }

    private static void solve(String s, int index, String curr, List<String> res)  {
        if (index >= s.length()) {
            res.add(curr);
            return;
        }

        solve(s, index + 1, curr + s.charAt(index), res);
        solve(s, index + 1, curr, res);
    }

    public static void main(String[] args) {
        String s = "abc";
        System.out.println(subsequences(s));
    }
}
