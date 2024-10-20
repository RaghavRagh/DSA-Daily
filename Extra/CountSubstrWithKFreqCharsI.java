import java.util.HashMap;

public class CountSubstrWithKFreqCharsI {

    private static int numberOfSubstrings(String s, int k) {
        int n = s.length();
        int res = 0;
        HashMap<Character, Integer> map = new HashMap<>();
        int left = 0;

        for (int right = 0; right < n; right++) {
            char currChar = s.charAt(right);
            map.put(currChar, map.getOrDefault(currChar, 0) + 1);

            while (isValid(map, k)) {
                res += n - right;

                char leftChar = s.charAt(left);
                map.put(leftChar, map.get(leftChar) - 1);
                if (map.get(leftChar) == 0) {
                    map.remove(leftChar);
                }
                left++;
            }
        }

        return res;
    }

    private static boolean isValid(HashMap<Character, Integer> map, int k) {
        for (int count : map.values()) {
            if (count >= k) {
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        String s = "abacb";
        int k = 2;
        System.out.println(numberOfSubstrings(s, k));
    }
}
