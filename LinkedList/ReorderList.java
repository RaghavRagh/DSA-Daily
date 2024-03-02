// 143
// https://leetcode.com/problems/reorder-list/

import NodeClass.Node;

public class ReorderList {
    public void reorderList(Node head) {
        if (head == null || head.next == null) {
            return;
        }

        //finding mid
        Node slow = head;
        Node fast = head;

        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        // make second list
        Node head2 = slow.next;
        slow.next = null;

        //reverse list2
        Node prev = null;
        Node next = null;
        Node curr = head2;

        while (curr != null) {
            next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }

        head2 = prev;
        curr = head2;

        merge(head, head2);
    }

    private void merge(Node l1, Node l2) {
        while (l1 != null && l2 != null) {
            Node l1_next = l1.next;
            Node l2_next = l2.next;

            l1.next = l2;
            if (l1_next == null) {
                break;
            }

            l2.next = l1_next;
            l1 = l1_next;
            l2 = l2_next;
        }
    }

    public static void main(String[] args) {
        Node head = new Node(1);
        Node n2 = new Node(2);
        Node n3 = new Node(3);
        Node n4 = new Node(4);
        Node n5 = new Node(5);

        head.next = n2;
        n2.next = n3;
        n3.next = n4;
        n4.next = n5;

        ReorderList reorder = new ReorderList();
        reorder.reorderList(head);
    }
}
