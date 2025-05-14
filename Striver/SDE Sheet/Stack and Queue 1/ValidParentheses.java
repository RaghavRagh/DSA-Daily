import java.util.Stack;

public class ValidParentheses {

    private static boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();

        for (char i : s.toCharArray()) {
            if (i == '(' || i == '[' || i == '{') {
                stack.add(i);
            } else {
                if (stack.isEmpty()) {
                    return false;
                }
                char ch = stack.pop();
                if ((i == ')' && ch == '(') || (i == ']' && ch == '[') || (i == '}' && ch == '{')) {
                    continue;
                } else {
                    return false;
                }
            }
        }

        return stack.isEmpty();
    }
    
    public static void main(String[] args) {
        String s = "(){}}{";
        System.out.println(isValid(s));
    }
}
