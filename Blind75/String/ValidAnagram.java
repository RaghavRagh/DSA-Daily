import java.util.HashMap;

public class ValidAnagram {
    
    public static boolean isAnagram(String s, String t) {
        if (s.isEmpty() || t.isEmpty()) {
            return true;
        }

        HashMap<Character, Integer> map = new HashMap<>();

        for(char i : s.toCharArray()) {
            map.put(i, map.getOrDefault(i, 0) + 1);
        }

        for(char i : t.toCharArray()) {
            map.put(i, map.getOrDefault(i, 0) - 1);
        }

        for (int v : map.values()) {
            if (v != 0) {
                return false;
            }
        }

        return true;
    }
    
    public static void main(String[] args) {
        String s = "anagram";
        String t = "nagaram";
        boolean ans = isAnagram(s, t);
        System.out.println(ans);
    }
}
