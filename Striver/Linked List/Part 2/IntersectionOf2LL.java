public class IntersectionOf2LL {

    static class Node {
        int data;
        Node next;

        Node(int data) {
            this.data = data;
            this.next = null;
        }
    }

    static Node getIntersectionNode(Node headA, Node headB) {
        if (headA == null || headB == null) {
            return null;
        }

        Node a = headA;
        Node b = headB;

        while (a != b) {
            a = a == null ? headB : a.next;
            b = b == null ? headA : b.next;
        }

        return a;
    }

    static void printList(Node head) {
        if (head == null) {
            return;
        }

        Node temp = head;
        while (temp != null) {
            System.out.print(temp.data + " ");
            temp = temp.next;
        }
    }

    public static void main(String[] args) {
        Node headA = new Node(0);
        headA.next = new Node(1);
        headA.next.next = new Node(2);
        headA.next.next.next = new Node(3);
        headA.next.next.next.next = new Node(4);

        Node headB = new Node(7);
        headB.next = new Node(8);
        headB.next.next = new Node(9);
        headB.next.next.next = headA.next.next;

        Node ans = getIntersectionNode(headA, headB);
        System.out.println(ans.data);
    }
}
