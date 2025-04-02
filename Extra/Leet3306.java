import java.util.HashMap;

public class Leet3306 {

    private static int countOfSubstrings(String word, int k) {
        int n = word.length();
        int res = 0, left = 0, consonants = 0;
        HashMap<Character, Integer> map = new HashMap<>();

        for (int right = 0; right < n; right++) {
            char c = word.charAt(right);
            if (isVowel(c)) {
                map.put(c, map.getOrDefault(c, 0) + 1);
            } else {
                consonants++;
            }

            while (map.size() == 5 && consonants >= k) {
                res += n - right;
                char leftChar = word.charAt(left);
                if (isVowel(leftChar)) {
                    map.put(leftChar, map.getOrDefault(leftChar, 0) - 1);
                    if (map.get(leftChar) == 0) {
                        map.remove(leftChar);
                    }
                } else {
                    consonants--;
                }
                left++;
            }
        }

        return res;
    }

    private static boolean isVowel(char c) {
        return c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u';
    }

    public static void main(String[] args) {
        String word = "iqeaouqi";
        System.out.println(countOfSubstrings(word, 2)); // Expected output: 3
    }
}
