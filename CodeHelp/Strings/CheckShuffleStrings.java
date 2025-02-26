import java.util.HashMap;

public class CheckShuffleStrings {

    private static boolean isShuffle(String str1, String str2, String shuffle) {
        if (shuffle.length() != str1.length() + str2.length()) {
            return false;
        }

        HashMap<Character, Integer> map = new HashMap<>();
        for (char c : str1.toCharArray()) {
            map.put(c, map.getOrDefault(c, 0) + 1);
        }

        for (char c : str2.toCharArray()) {
            map.put(c, map.getOrDefault(c, 0) + 1);
        }

        for (char c : shuffle.toCharArray()) {
            if (!map.containsKey(c) || map.get(c) == 0) {
                return false;
            }
            map.put(c, map.get(c) - 1);
        }

        return true;
    }

    public static void main(String[] args) {
        String str1 = "BA", str2 = "XY", shuffle = "BAXY";
        System.out.println(isShuffle(str1, str2, shuffle));
    }
}
