import Node.Node;

public class RemoveLinkedListElements {

    private static Node removeElements(Node head, int val) {
        if (head == null)
            return null;

        while (head != null && head.data == val) {
            head = head.next;
        }

        Node curr = head;

        while (curr != null && curr.next != null) {
            if (curr.next.data == val) {
                curr.next = curr.next.next;
            } else {
                curr = curr.next;
            }

        }

        return head;
    }

    static void printList(Node node) {
        Node temp = node;

        while (temp != null) {
            System.out.print(temp.data + " ");
            temp = temp.next;
        }
    }

    public static void main(String[] args) {
        // Node head = new Node(1);
        // head.next = new Node(2);
        // head.next.next = new Node(6);
        // head.next.next.next = new Node(3);
        // head.next.next.next.next = new Node(4);
        // head.next.next.next.next.next = new Node(5);
        // head.next.next.next.next.next.next = new Node(6);

        Node head = new Node(1);
        head.next = new Node(2);
        head.next.next = new Node(2);
        head.next.next.next = new Node(1);

        head = removeElements(head, 2);
        printList(head);
    }
}
