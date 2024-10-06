import java.util.HashMap;

public class Q3297 {
    
    private static long validSubstringCount(String word1, String word2) {
        int n = word1.length();
        int m = word2.length();
        if (m > n) return 0;

        HashMap<Character, Integer> map1 = new HashMap<>();
        HashMap<Character, Integer> map2 = new HashMap<>();

        for (char c : word2.toCharArray()) {
            map2.put(c, map2.getOrDefault(c, 0) + 1);
        }

        long result = 0;
        int required = map2.size();
        int formed = 0;
        int left = 0;

        for (int right = 0; right < n; right++) {
            char c = word1.charAt(right);
            map1.put(c, map1.getOrDefault(c, 0) + 1);

            if (map2.containsKey(c) && map1.get(c).intValue() == map2.get(c).intValue()) {
                formed++;
            }

            while (formed == required) {
                result += (n - right);
                char leftChar = word1.charAt(left);

                if (map2.containsKey(leftChar) && map1.get(leftChar) < map2.get(leftChar)) {
                    formed--;
                }
                left++;
            }
        }

        return result;
    }
    
    public static void main(String[] args) {
        String word1 = "bcca";
        String word2 = "abc";

        System.out.println(validSubstringCount(word1, word2));
    }
}
