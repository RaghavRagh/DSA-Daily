import java.util.HashMap;

public class Leet1358 {

    private static int numberOfSubstrings(String s) {
        HashMap<Character, Integer>  map = new HashMap<>();
        int left = 0, right = 0, res = 0, length = s.length();

        while (right < length) {
            char curr = s.charAt(right);
            map.put(curr, map.getOrDefault(curr, 0) + 1);

            while (map.size() == 3) {
                res += length - right;
                char leftChar = s.charAt(left);
                map.put(leftChar, map.get(leftChar) - 1);
                if (map.get(leftChar) == 0) {
                    map.remove(leftChar);
                }
                left++;
            }
            right++;
        }

        return res;
    }

    public static void main(String[] args) {
        String s = "abcabc";
        System.out.println(numberOfSubstrings(s));
    }
}
