import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class NextSmallerElement {

    private static ArrayList<Integer> prevSmaller(ArrayList<Integer> list) {
        ArrayList<Integer> res = new ArrayList<>(list.size());
        Stack<Integer> s = new Stack<>();

        for (int i = 0; i < list.size(); i++) {
            int currentElement = list.get(i);
            
            while (!s.isEmpty() && s.peek() >= currentElement) {
                s.pop();
            }

            if (s.isEmpty()) {
                res.add(-1);
            } else {
                res.add(s.peek());
            }

            s.push(currentElement);
        }

        return res;
    }

    public static void main(String[] args) {
        ArrayList<Integer> list = new ArrayList<>(List.of(4, 5, 2, 10, 8));
        ArrayList<Integer> ans = prevSmaller(list);
        System.out.println(ans);

    }
}