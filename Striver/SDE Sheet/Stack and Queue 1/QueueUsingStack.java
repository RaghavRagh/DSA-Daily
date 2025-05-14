import java.util.Stack;

public class QueueUsingStack {
    
    Stack<Integer> s1;
    Stack<Integer> s2;

    QueueUsingStack() {
        s1 = new Stack<>();
        s2 = new Stack<>();
    }

    public void push(int x) {
        while (!s1.isEmpty()) {
            s2.push(s1.pop());
        }
        s1.push(x);

        while (!s2.isEmpty()) {
            s1.push(s2.pop());
        }
    }

    public int pop() {
        return s1.pop();
    }
    
    public int peek() {
        return s1.peek();
    }
    
    public boolean empty() {
        return s1.empty();
    }
    
    public static void main(String[] args) {
        QueueUsingStack qst = new QueueUsingStack();
        qst.push(4);
        qst.push(3);
        qst.push(2);
        qst.push(5);
        System.out.println("Top -> " + qst.peek());
        System.out.println("Popped -> " + qst.pop());
        System.out.println("Top -> " + qst.peek());
    }
}
