public class Queue {

    int[] arr;
    int start, end, currSize, maxSize;

    public Queue() {
        arr = new int[10];
        start = -1;
        end = -1;
        currSize = 0;
    }

    public Queue(int maxSize) {
        this.maxSize = maxSize;
        arr = new int[maxSize];
        start = -1;
        end = -1;
        currSize = 0;
    }

    boolean isFull() {
        if (currSize == maxSize) {
            System.out.println("Queue is full!");
            return true;
        }

        return false;
    }

    boolean isEmpty() {
        if (start == -1) {
            System.out.println("Queue is Empty!");
            return true;
        }

        return false;
    }

    void push(int data) {
        if (isFull()) {
            System.exit(1);
        }

        if (end == -1) {
            start = 0;
            end = 0;
        } else {
            end = (end + 1) % maxSize;
        }

        arr[end] = data;
        System.out.println("Element pushed: " + data);
        currSize++;
    }

    int pop() {
        if (isEmpty()) {
            System.exit(1);
        }

        int popped = arr[start];
        if (currSize == 1) {
            start = -1;
            end = -1;
        } else {
            System.out.println(start);
            start = (start + 1) % maxSize;
            System.out.println(start);
        }
 
        currSize--;
        return popped;
    }

    int peek() {
        if (isEmpty()) {
            System.exit(1);
        }

        return arr[start];
    }

    int size() {
        return currSize;
    }

    public static void main(String[] args) {
        Queue q = new Queue(4);
        q.push(4);
        q.push(44);
        q.push(81);
        q.push(6);
        // q.push(32);
        System.out.println("The peek of the queue before deleting any element " + q.peek());
        System.out.println("The size of the queue before deletion " + q.size());
        System.out.println("The first element to be deleted " + q.pop());
        System.out.println("The peek of the queue after deleting an element " + q.peek());
        System.out.println("The size of the queue after deleting an element " + q.size());
    }
}