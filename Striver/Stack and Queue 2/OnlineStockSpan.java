import java.util.Stack;

public class OnlineStockSpan {
    
    Stack<int[]> s;
    // price, ans
    public OnlineStockSpan() {
        s = new Stack<>();
    }
    
    public int next(int price) {
        int span = 1;

        // monotonically decreasing stack
        while (!s.isEmpty() && s.peek()[0] <= price) {
            span += s.pop()[1];
        }
        s.add(new int[]{price, span});
        
        return span;
    }
    
    public static void main(String[] args) {
        OnlineStockSpan obj = new OnlineStockSpan();
        int[] prices = { 28, 14, 28, 35, 46, 53, 66, 80, 87, 88 };
        for (int i : prices) {
            System.out.print(obj.next(i) + " ");
        }
        
    }
}
