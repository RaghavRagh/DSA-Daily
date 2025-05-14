public class FlattenLinkedList {

    static class Node {
        int data;
        Node next;
        Node bottom;

        Node(int data) {
            this.data = data;
            this.next = null;
            this.bottom = null;
        }
    }

    static Node mergeList(Node a, Node b) {
        Node temp = new Node(0);
        Node res = temp;

        while (a != null && b != null) {
            if (a.data < b.data) {
                temp.bottom = a;
                temp = temp.bottom;
                a = a.bottom;
            } else {
                temp.bottom = b;
                temp = temp.bottom;
                b = b.bottom;
            }
        }

        if (a != null) {
            temp.bottom = a;
        } else {
            temp.bottom = b;
        }

        return res.bottom;
    }

    static Node flatten(Node root) {
        if (root == null || root.next == null) {
            return root;
        }

        root.next = flatten(root.next);
        root = mergeList(root, root.next);
        return root;
    }

    static void printList(Node head) {
        if (head == null) {
            return;
        }
        Node curr = head;
        while (curr != null) {
            System.out.print(curr.data + " ");
            curr = curr.bottom;
        }
    }

    public static void main(String[] args) {
        Node head = new Node(5);
        head.next = new Node(10);
        head.next.next = new Node(19);
        head.next.next.next = new Node(28);

        head.bottom = new Node(7);
        head.bottom.bottom = new Node(8);
        head.bottom.bottom.bottom = new Node(30);

        head.next.next.bottom = new Node(22);
        head.next.next.bottom.bottom = new Node(50);
        head.next.next.bottom.bottom.bottom = new Node(56);

        head = flatten(head);
        printList(head);
    }
}
