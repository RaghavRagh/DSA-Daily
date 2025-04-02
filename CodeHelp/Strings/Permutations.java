import java.util.ArrayList;
import java.util.List;

public class Permutations {

    private static List<String> permutations(String s) {
        List<String> res = new ArrayList<>();
        solve(s.toCharArray(), 0, res);
        return res;
    }

    private static void solve(char[] s, int index, List<String> res) {
        if (index >= s.length) {
            res.add(String.valueOf(s));
            return;
        }

        for (int i = index; i < s.length; i++) {
            swap(s, i, index);
            solve(s, index + 1, res);
            swap(s, i, index);
        }
    }

    private static void swap(char[] s, int i, int j) {
        char temp = s[i];
        s[i] = s[j];
        s[j] = temp;
    }

    public static void main(String[] args) {
        String s = "abc";
        System.out.println(permutations(s));
    }
}
