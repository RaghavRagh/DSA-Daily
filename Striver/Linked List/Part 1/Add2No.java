import Node.Node;

public class Add2No {

    private static Node addTwoNumbers(Node head1, Node head2) {
        Node newNode = new Node(0);
        Node ptr = newNode;
        int carry = 0;

        while (head1 != null || head2 != null) {
            int sum = 0 + carry;
            
            if (head1 != null) {
                sum += head1.data;
                head1 = head1.next;
            }

            if (head2 != null) {
                sum += head2.data;
                head2 = head2.next;
            }

            // if (sum > 9) {
                carry = sum / 10;
                sum %= 10;
            // }

            ptr.next = new Node(sum);
            ptr = ptr.next;
        }

        if (carry == 1) {
            ptr.next = new Node(carry);
        }

        return newNode.next;
    }

    static void printList(Node node) {
        Node temp = node;
        
        while (temp != null) {
            System.out.print(temp.data + " ");
            temp = temp.next;
        }
    }
    
    public static void main(String[] args) {
        Node head1 = new Node(2);
        head1.next = new Node(4);
        head1.next.next = new Node(3);

        Node head2 = new Node(5);
        head2.next = new Node(6);
        head2.next.next = new Node(4);

        Node newNode = addTwoNumbers(head1, head2);
        printList(newNode);
    }
}
