import Node.Node;

public class LinkedListCycle2 {

    private static Node detectNode(Node head) {
        if (head == null || head.next == null) {
            return null;
        }

        Node slow = head;
        Node fast = head;

        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;

            if (slow == fast) {
                slow = head;
                while (slow != fast) {
                    slow = slow.next;
                    fast = fast.next;
                }

                return slow;
            }
        }

        return null;
    }

    public static void main(String[] args) {
        Node head = new Node(3);
        head.next = new Node(2);
        // head.next.next = new Node(0);
        // head.next.next.next = new Node(-4);
        // head.next.next.next.next = head.next; // cycle

        Node ans = detectNode(head);

        if (ans == null) {
            System.out.println("No cycle");
        } else {
            System.out.println(ans.data);
        }
        
    }
}
