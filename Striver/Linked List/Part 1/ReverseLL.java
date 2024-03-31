import Node.Node;

public class ReverseLL {

    // Iterative approach
    private static Node reverseLLIteratively(Node head) {
        Node prev = null;
        Node curr = head;
        Node next = null;

        while (curr != null) {
            next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }

        head = prev;
        return head;
    }

    // recursice approach
    static Node reverseRecursively(Node head) {
        if (head == null || head.next == null)
            return head;

        Node rest = reverseRecursively(head.next);
        head.next.next = head;

        head.next = null;
        return rest;
    }

    private static void printList(Node head) {
        Node temp = head;

        while (temp != null) {
            System.out.print(temp.data + " ");
            temp = temp.next;
        }
    }

    public static void main(String[] args) {
        Node head = new Node(1);
        head.next = new Node(2);
        head.next.next = new Node(3);
        head.next.next.next = new Node(4);
        head.next.next.next.next = new Node(5);

        // head = reverseLLIteratively(head);
        head = reverseRecursively(head);
        printList(head);
    }
}