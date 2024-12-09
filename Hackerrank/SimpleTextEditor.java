import java.util.Scanner;
import java.util.Stack;

public class SimpleTextEditor {

    private static void append(StringBuilder W, String str) {
        W.append(str);
    }

    private static String delete(StringBuilder W, int k) {
        String deletedtext = W.substring(W.length() - k);
        W.delete(W.length() - k, W.length());
        return deletedtext;
    }

    private static void print(StringBuilder W, int k) {
        System.out.println(W.charAt(k - 1));
    }

    private static void undo(StringBuilder W, Stack<Operation> history) {
        if (!history.isEmpty()) {
            Operation last = history.pop();
            if (last.type == 1) {
                W.delete(W.length() - last.length, W.length());
            } else {
                W.append(last.text);
            }
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        StringBuilder W = new StringBuilder("");
        Stack<Operation> history = new Stack<>();
        int noOfOperation = sc.nextInt();

        while (noOfOperation-- > 0) {
            int type = sc.nextInt();
            switch (type) {
                case 1:
                    String str = sc.next();
                    history.push(new Operation(type, str.length()));
                    append(W, str);
                    break;

                case 2:
                    int k = sc.nextInt();
                    String deletedText = delete(W, k);
                    history.push(new Operation(type, deletedText));
                    break;

                case 3:
                    int p = sc.nextInt();
                    print(W, p);
                    break;

                case 4:
                    undo(W, history);
                    break;

                default:
                    break;
            }
        }

        sc.close();
    }
}

class Operation {
    int type;
    String text;
    int length;

    public Operation(int type, int length) {
        this.type = type;
        this.length = length;
    }

    public Operation(int type, String text) {
        this.type = type;
        this.text = text;
    }
}