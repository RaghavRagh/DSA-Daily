public class Palindrome {

    // Approach 1
    static Node findMiddle(Node head) {
        Node slow = head;
        Node fast = head;

        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        return slow;
    }

    static Node reverse(Node head) {
        if (head == null || head.next == null) {
            return head;
        }

        Node res = reverse(head.next);
        head.next.next = head;
        head.next = null;

        return res;
    }

    static boolean isPalindrome1(Node head) {
        if (head == null || head.next == null) {
            return true;
        }

        Node middle = findMiddle(head);
        Node head2 = reverse(middle);

        Node temp1 = head;
        Node temp2 = head2;

        while (temp1 != null && temp2 != null) {
            if (temp1.data != temp2.data) {
                return false;
            }

            temp1 = temp1.next;
            temp2 = temp2.next;
        }

        return true;
    }

    // Approach 2
    static boolean isPalindrome2(Node head) {
        Node fast = head;
        Node slow = head;
        Node prev = null;

        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            Node temp = slow.next;
            slow.next = prev;
            prev = slow;
            slow = temp;
        }

        if (fast != null) {
            slow = slow.next;
        }

        while (prev != null && slow != null) {
            if (prev.data != slow.data) {   
                return false;
            }

            prev = prev.next;
            slow = slow.next;
        }

        return true;
    }

    public static void main(String[] args) {
        Node head = new Node(1);
        head.next = new Node(2);
        head.next.next = new Node(2);
        head.next.next.next = new Node(1);

        System.out.println(isPalindrome2(head));
    }
}
