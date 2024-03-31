import NodeClass.Node;

public class RemoveNthNodeFromEnd {

    // within 1 traversal
    private void remove(Node head, int n) {
        Node dummy = new Node(-1);
        dummy.next = head;

        Node p1 = dummy;
        Node p2 = dummy;

        for (int i = 0; i < n; i++) {
            p2 = p2.next;
        }

        while (p2.next != null) {
            p1 = p1.next;
            p2 = p2.next;
        }

        p1.next = p1.next.next;

        return;
    }

    public static void main(String[] args) {
        Node head = new Node(1);
        Node n2 = new Node(2);
        Node n3 = new Node(3);
        // Node n4 = new Node(4);
        // Node n5 = new Node(5);

        head.next = n2;
        n2.next = n3;
        // n3.next = n4;
        // n4.next = n5;

        Node n = new Node();
        n.printList(head);
        System.out.println();

        RemoveNthNodeFromEnd obj = new RemoveNthNodeFromEnd();
        obj.remove(head, 2);

        n.printList(head);
    }
}