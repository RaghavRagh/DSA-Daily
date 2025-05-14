import java.util.LinkedList;
import java.util.Queue;

public class StackUsingQueues {

    Queue<Integer> q1;
    Queue<Integer> q2;

    StackUsingQueues() {
        q1 = new LinkedList<>();
        q2 = new LinkedList<>();
    }

    public void push(int x) {
        q2.offer(x);

        while (!q1.isEmpty()) {
            q2.offer(q1.poll());
        }

        while (!q2.isEmpty()) {
            q1.offer(q2.poll());
        }
    }

    // using single queue
    void pushUsingSingleQueue(int x) {
        q1.add(x);
        for (int i = 0; i < q1.size() - 1; i++) {
            q1.add(q1.remove());
        }
    }
    
    public int pop() {
        return q1.poll();   
    }

    public int top() {
        return q1.peek();
    }

    public boolean empty() {
        return q1.isEmpty();
    }
    
    public static void main(String[] args) {
        StackUsingQueues stq = new StackUsingQueues();
        stq.push(3);
        stq.push(4);
        stq.push(2);
        stq.push(1);
        System.out.println("Top -> " + stq.top());
        System.out.println("Popped -> " + stq.pop());
        System.out.println("Top -> " + stq.top());
    }
}
