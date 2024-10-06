import java.util.HashMap;

public class LongestSubstrWithoutRepChar {

    private static int lengthOfLongestSubstring(String str) {
        HashMap<Character, Integer> map = new HashMap<>();
        int left = 0, right = 0, length = 0;

        for (int i = 0; i < str.length(); i++) {
            if (map.containsKey(str.charAt(i))) {
                left = Math.max(map.get(str.charAt(i)) + 1, left);
            }

            map.put(str.charAt(i), i);
            length = Math.max(length, right - left + 1);
            right++;
        }

        return length;
    }

    public static void main(String[] args) {
        String str = "abcabcbb";
        System.out.println(lengthOfLongestSubstring(str));
    }
}
