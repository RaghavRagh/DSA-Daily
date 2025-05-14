import java.util.Stack;

public class SortAStack {

    // iteratively
    private static Stack<Integer> sortStackIterative(Stack<Integer> s) {
        Stack<Integer> tempStack = new Stack<>();
        while (!s.empty()) {
            int temp = s.pop();

            while (!tempStack.isEmpty() && tempStack.peek() < temp) {
                s.push(tempStack.pop());
            }

            tempStack.push(temp);
        }

        return tempStack;
    }

    // recursively
    private static void sortedInsert(Stack<Integer> s, int x) {
        // Base case: Either stack is empty or newly inserted
        // item is greater than top (more than all existing)

        if (s.empty() || x > s.peek()) {
            s.push(x);
            return;
        }

        // if top is greater, remove the top item and recur
        int temp = s.pop();
        sortedInsert(s, x);

        // put back the top item remove earlier
        s.push(temp);
    }

    // sort stack
    private static void sortStackRecursive(Stack<Integer> s) {
        // if stack is not tempty
        if (!s.isEmpty()) {
            int x = s.pop();
            sortStackRecursive(s);
            // push the top item in the sorted stack
            sortedInsert(s, x);
        }
    }

    public static void main(String[] args) {
        Stack<Integer> s = new Stack<>();
        s.push(30);
        s.push(-5);
        s.push(18);
        s.push(14);
        s.push(-3);

        // Stack<Integer> tempStack = sortstack(s);
        // System.out.println(tempStack);
        System.out.println(s);
        sortStackRecursive(s);
        System.out.println(s);
    }
}
