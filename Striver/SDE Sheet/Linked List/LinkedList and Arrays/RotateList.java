import Node.Node;

public class RotateList {

    static Node rotateRight(Node head, int k) {
        if (head == null || head.next == null) {
            return head;
        }

        Node temp = head;
        int length = 1;
        while (temp.next != null) {
            ++length;
            temp = temp.next;
        }

        temp.next = head;
        k = k % length;
        int end = length - k;

        while(end-- != 0) {
            temp = temp.next;
        }

        head = temp.next;
        temp.next = null;

        return head;
    }

    static void printList(Node head) {
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

        int k = 2;
        head = rotateRight(head, k);
        printList(head);
    }
}