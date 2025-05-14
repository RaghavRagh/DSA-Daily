import Node.Node;

public class Merge2SortedLL {

    private static Node merge(Node l1, Node l2) {
        Node t1 = l1;
        Node t2 = l2;
        Node dummyNode = new Node(-1);
        Node ptr = dummyNode;

        while (t1 != null && t2 != null) {
            if (t1.data < t2.data) {
                ptr.next = t1;
                ptr = t1;
                t1 = t1.next;
            } else {
                ptr.next = t2;
                ptr = t2;
                t2 = t2.next;
            }
        }

        while (t1 != null) {
            ptr.next = t1;
            ptr = t1;
            t1 = t1.next;
        }

        while (t2 != null) {
            ptr.next = t2;
            ptr = t2;
            t2 = t2.next;
        }

        return dummyNode.next;
    }

    private static void printList(Node node) {
        Node temp = node;
        
        while (temp != null) {
            System.out.print(temp.data + " ");
            temp = temp.next;
        }
    }

    public static void main(String[] args) {
        Node head1 = new Node(1);
        head1.next = new Node(2);
        head1.next.next = new Node(4);

        Node head2 = new Node(1);
        head2.next = new Node(3);
        head2.next.next = new Node(4);

        Node head3 = merge(head1, head2);
        printList(head3);
    }
}
