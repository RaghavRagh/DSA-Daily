import java.util.ArrayList;
import java.util.List;

public class LexicographicalNumbers {
    
    private static List<Integer> lexicalOrder(int n) {
        List<Integer> res = new ArrayList<>();
        for (int start = 1; start <= 9; ++start) {
            generateLexicalNumber(start, n, res);
        }

        return res;
    }

    private static void generateLexicalNumber(int currentNum, int limit, List<Integer> res) {
        if (currentNum > limit) return;

        res.add(currentNum);

        for (int nextDigit = 0; nextDigit <= 9; ++nextDigit) {
            int nextNum = currentNum * 10 + nextDigit;
            if (nextNum <= limit) {
                generateLexicalNumber(nextNum, limit, res);
            } else {
                break;
            }
        }
    }
    
    public static void main(String[] args) {
        int n = 13;
        List<Integer> res = lexicalOrder(n);
        System.out.println(res);
    }
}
