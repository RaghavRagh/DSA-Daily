import Node.Node;

public class ReverseNodesInKGroup {

    private static Node findKthNode(Node temp, int k) {
        int count = 1;
        while (count != k && temp != null) {
            count++;
            temp = temp.next;
        }

        return temp;
    }

    private static void reverse(Node head) {
        Node prev = null;
        Node curr = head;
        Node next = null;

        while (curr != null) {
            next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
    }

    private static Node reverseKGroup(Node head, int k) {
        Node temp = head;
        Node prev = null;

        while (temp != null) {
            Node kThNode = findKthNode(temp, k);
            if (kThNode == null) {
                if (prev != null) {
                    prev.next = temp;
                }
                break;
            } else {
                Node nextNode = kThNode.next;
                kThNode.next = null;
                reverse(temp);

                if (temp == head) {
                    head = kThNode;
                } else {
                    prev.next = kThNode;
                }

                prev = temp;
                temp = nextNode;
            }
        }

        return head;
    }

    private static void printList(Node head) {
        Node temp = head;
        while (temp != null) {
            System.out.print(temp.data + " ");
            temp = temp.next;
        }
    }

    public static void main(String[] args) {
        // 1 -> 2 -> 3 -> 4 -> 5
        // 2 -> 1 -> 4 -> 3 -> 5

        Node head = new Node(1);
        head.next = new Node(2);
        head.next.next = new Node(3);
        head.next.next.next = new Node(4);
        head.next.next.next.next = new Node(5);

        int k = 2;
        head = reverseKGroup(head, k);
        printList(head);
    }
}
