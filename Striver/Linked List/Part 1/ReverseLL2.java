public class ReverseLL2 {

    class Node {
        int data;
        Node next;

        Node(int data) {
            this.data = data;
            this.next = null;
        }
    }

    private Node reverse(Node temp) {
        Node prev = null;
        Node curr = temp;
        Node next = null;

        while (curr != null) {
            next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }

        return prev;
    }

    private Node reverseBetween(Node head, int left, int right) {
        if(head == null || head.next == null) {
            return head;
        }

        if (left == right) {
            return head;
        }

        Node dummy = new Node(-1);
        dummy.next = head;
        Node prev = dummy;

        for (int i = 1; i < left; i++) {
            prev = prev.next;
        }

        Node leftNode = prev.next;
        Node rightNode = leftNode;
        
        for (int i = left; i < right; i++) {
            rightNode = rightNode.next;
        }
        
        Node next = rightNode.next;
        prev.next = reverse(leftNode);

        leftNode.next = next;
        
        return head;
    }

    private void printList(Node head) {
        Node curr = head;
        while (curr != null) {
            System.out.print(curr.data + " ");
            curr = curr.next;
        }
    }
    
    public static void main(String[] args) {
        ReverseLL2 r = new ReverseLL2();
        Node head = r.new Node(1);
        head.next = r.new Node(2);
        head.next.next = r.new Node(3);
        head.next.next.next = r.new Node(4);
        head.next.next.next.next = r.new Node(5);
        head.next.next.next.next.next = r.new Node(6);
        // Node head = r.new Node(3);
        // head.next = r.new Node(5);

        head = r.reverseBetween(head, 3, 5);

        r.printList(head);
    }
}