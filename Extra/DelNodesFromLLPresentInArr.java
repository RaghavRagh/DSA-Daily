import java.util.HashSet;

public class DelNodesFromLLPresentInArr {

    static class Node {
        int val;
        Node next = null;

        Node(int val) {
            this.val = val;
            this.next = null;
        }
    }

    static void printList(Node head) {
        Node temp = head;
        while (temp != null) {
            System.out.print(temp.val + " ");
            temp = temp.next;
        }
    }

    private static Node modifiedList(int[] nums, Node head) {
        if (head == null) {
            return null;
        }

        var set = new HashSet<>();
        for (int i : nums) {
            set.add(i);
        }

        while (head != null && set.contains(head.val)) {
            head = head.next;
        }

        Node temp = new Node(-1);
        temp.next = head;

        while (temp.next != null) {
            if (set.contains(temp.next.val)) {
                temp.next = temp.next.next;
            } else {
                temp = temp.next;
            }
        }

        return head;
    }

    public static void main(String[] args) {
        Node head = new Node(1);
        head.next = new Node(2);
        head.next.next = new Node(3);
        head.next.next.next = new Node(4);
        head.next.next.next.next = new Node(5);

        int[] nums = { 1, 2, 3 };
        head = modifiedList(nums, head);

        printList(head);
    }
}