public class ReverseLL {
    
    class Node {
        int data;
        Node next;

        Node (int data) {
            this.data = data;
            this.next = null;
        }
    }

    Node head = null;

    private void insertAtEnd(int data) {
        if (head == null) {
            Node newNode = new Node(data);
            head = newNode;
            return;
        }

        Node newNode = new Node(data);

        Node curr = head;
        while (curr.next != null) {
            curr = curr.next;
        }

        curr.next = newNode;
    }

    private void reverseList(Node head) {
        if (head == null) {
            System.out.println("Empty List!");
            return;
        }

        Node prev = null;
        Node next = null;
        Node curr = head;

        while (curr != null) {
            next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }

        head = prev;
    }
    
    public void printList(Node head) {
        if (head == null) {
            System.out.println("List empty!");
            return;
        }

        Node curr = head;
        while (curr != null) {
            System.out.print(curr.data + " ");
            curr = curr.next;
        }
    }
    
    public static void main(String[] args) {
        ReverseLL l = new ReverseLL();
        l.insertAtEnd(1);
        l.insertAtEnd(2);
        l.insertAtEnd(3);
        l.insertAtEnd(4);

        // l.printList(l.head);

        l.reverseList(l.head);
        l.printList(l.head);
    }
}
