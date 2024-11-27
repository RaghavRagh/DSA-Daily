import java.util.Stack;

public class MoveNegToEnd {

    private static void segregateElements(int[] arr) {
        Stack<Integer> pos = new Stack<>();
        Stack<Integer> neg = new Stack<>();

        for (int i : arr) {
            if (i < 0)
                neg.push(i);
            else
                pos.push(i);
        }

        int i = arr.length - 1;
        while (!neg.isEmpty()) {
            arr[i--] = neg.pop();
        }

        while (!pos.isEmpty()) {
            arr[i--] = pos.pop();
        }
    }

    public static void main(String[] args) {
        int[] arr = { 1, -1, 3, 2, -7, -5, 11, 6 };
        System.out.print("Before: ");
        for (int i : arr) {
            System.out.print(i + " ");
        }
        
        System.out.println();
        segregateElements(arr);

        System.out.print("After: ");
        for (int i : arr) {
            System.out.print(i + " ");
        }
    }
}
