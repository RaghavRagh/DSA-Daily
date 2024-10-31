import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;

public class FirstUniqueCharInStr {

    private static int firstUniqChar(String s) {
        LinkedHashMap<Character, List<Integer>> map = new LinkedHashMap<>();
        char[] charStr = s.toCharArray();

        for (int i = 0; i < charStr.length; i++) {
            map.computeIfAbsent(charStr[i], k -> new ArrayList<>()).add(i);
        }

        for (List<Integer> list : map.values()) {
            if (list.size() == 1) {
                return list.get(0);
            }
        }

        return -1;
    }

    public static void main(String[] args) {
        String s = "loveleetcode";
        System.out.println(firstUniqChar(s));
    }
}
