package NodeClass;

public class Node {
    public int data;
    public Node next;

    public Node() {
        
    }

    public Node(int data) {
        this.data = data;
        this.next = null;
    }

    public void printList(Node head) {
        if (head == null) {
            System.out.println("List is empty!");
            return;
        }

        Node curr = head;
        while (curr != null) {
            System.out.print(curr.data + " ");
            curr = curr.next;
        }
    }
}
