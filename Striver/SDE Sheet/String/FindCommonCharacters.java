import java.util.ArrayList;
import java.util.List;

public class FindCommonCharacters {

    private static List<String> commonChars(String[] words) {
        List<String> res = new ArrayList<>();

        for (char ch = 'a'; ch <= 'z'; ch++) {
            int minCount = Integer.MAX_VALUE;
            for (String word : words) {
                int count = 0;
                for (char c : word.toCharArray()) {
                    if (c == ch) count++;
                }
                minCount = Math.min(minCount, count);
            }

            for (int i = 0; i < minCount; i++) {
                res.add(String.valueOf(ch));
            }
        }

        return res;
    }
    
    public static void main(String[] args) {
        String[] words = {"bella","label","roller"};
        List<String> list = commonChars(words);
        System.out.println(list);
    }
}