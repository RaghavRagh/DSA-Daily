import Node.Node;

public class CopyListWithRandomPointer {

    private static Node copyRandomList(Node head) {
        Node temp = head;

        // linking nodes copy w original list
        while (temp != null) {
            Node copyNode = new Node(temp.data);
            copyNode.next = temp.next;
            temp.next = copyNode;
            temp = temp.next.next;
        }

        // connect random pointers
        temp = head;
        while (temp != null) {
            if (temp.random != null) {
                temp.next.random = temp.random.next;
            }

            temp = temp.next.next;
        }

        // removing connection of copied nodes from original list
        Node dummy = new Node(0);
        temp = dummy;
        Node temp2 = head;
        Node fast;

        while (temp2 != null) {
            fast = temp2.next.next;
            temp.next = temp2.next;
            temp2.next = fast;
            temp = temp.next;
            temp2 = fast;
        }

        return dummy.next;
    }

    static void printList(Node head) {
        Node temp = head;
        while (temp != null) {
            System.out.print(temp.data + " ");
            temp = temp.next;
        }
    }

    public static void main(String[] args) {
        Node head = null;

        Node node1 = new Node(1);
        Node node2 = new Node(2);
        Node node3 = new Node(3);
        Node node4 = new Node(4);

        head = node1;
        head.next = node2;
        head.next.next = node3;
        head.next.next.next = node4;

        head.random = node4;
        head.next.random = node1;
        head.next.next.random = null;
        head.next.next.next.random = node2;

        Node head2 = copyRandomList(head);
        printList(head2);
    }
}
