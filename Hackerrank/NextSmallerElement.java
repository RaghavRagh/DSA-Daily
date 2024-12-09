import java.util.Arrays;
import java.util.List;
import java.util.Stack;

public class NextSmallerElement {

    private static int[] help_classmate(List<Integer> list) {
        int[] res = new int[list.size()];
        Stack<Integer> s = new Stack<>();
        s.push(-1);

        for (int i = list.size() - 1; i >= 0; i--) {
            int curr = list.get(i);
            while (!s.isEmpty() && s.peek() >= curr) {
                s.pop();
            }
            res[i] = s.isEmpty() ? -1 : s.peek();
            s.push(curr);
        }

        return res;
    }

    public static void main(String[] args) {
        List<Integer> list = Arrays.asList(2, 5, 3, 7, 1, 5, 2, 6, 3, 1);
        int[] res = help_classmate(list);
        for (int i : res) {
            System.out.print(i + " ");
        }
    }
}