import java.util.ArrayList;
import java.util.List;

public class FindtheSeqOfStrAppearedOnScreen {

    private static List<String> stringSequence(String target) {
        List<String> list = new ArrayList<>();
        StringBuilder sb = new StringBuilder();

        for (char c : target.toCharArray()) {
            sb.append('a');
            list.add(sb.toString());
            while (sb.charAt(sb.length() - 1) != c) {
                char lastChar = sb.charAt(sb.length() - 1);
                lastChar = lastChar == 'z' ? 'a' : (char) (lastChar + 1);
                sb.setCharAt(sb.length() - 1, lastChar);
                list.add(sb.toString());
            }
        }

        return list;
    }

    public static void main(String[] args) {
        String target = "abc";
        System.out.println(stringSequence(target));
    }
}
