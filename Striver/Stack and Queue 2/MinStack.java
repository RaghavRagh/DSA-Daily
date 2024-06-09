import java.util.Stack;

// TC - O(1)
// SC - O(2n)

public class MinStack {

    class Pair {
        int x, y;
    
        Pair(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    Stack<Pair> st;
    
    public MinStack() {
        st = new Stack<>();
    }
    
    public void push(int val) {
        int min;

        if (st.isEmpty()) {
            min = val;
        } else {
            min = Math.min(st.peek().y, val);
        }

        st.push(new Pair(val, min));
    }
    
    public void pop() {
        st.pop();
    }
    
    public int top() {
        return st.peek().x;
    }
    
    public int getMin() {
        return st.peek().y;
    }
    
    public static void main(String[] args) {
        MinStack obj = new MinStack();
        obj.push(2);
        obj.push(5);
        obj.push(-3);

        System.out.println(obj.getMin());
        obj.pop();
        System.out.println(obj.top());
        System.out.println(obj.getMin());
    }
}
