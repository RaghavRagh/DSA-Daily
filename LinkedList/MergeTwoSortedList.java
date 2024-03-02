import NodeClass.Node;

public class MergeTwoSortedList {

    // iterative approach
    public Node mergeTwoLists(Node list1, Node list2) {
        Node t1 = list1;
        Node t2 = list2;
        Node dummyNode = new Node(-1);
        Node temp = dummyNode;

        while (t1 != null && t2 != null) {
            if (t1.data < t2.data) {
                temp.next = t1;
                temp = t1;
                t1 = t1.next;
            } else {
                temp.next = t2;
                temp = t2;
                t2 = t2.next;
            }
        }

        while (t1 != null) {
            temp.next = t1;
            temp = t1;
            t1 = t1.next;
        }

        while (t2 != null) {
            temp.next = t2;
            temp = t2;
            t2 = t2.next;
        }

        return dummyNode.next;
    }

    // recursive approach
    public Node mergeTwoLists2(Node list1, Node list2) {

        if (list1 != null && list2 != null) {
            if (list1.data < list2.data) {
                list1.next = mergeTwoLists2(list1.next, list2);
                return list1;
            } else {
                list2.next = mergeTwoLists2(list1, list2.next);
                return list2;
            }
        }

        if (list1 == null)
            return list2;
            
        return list1;
    }

    private void printList(Node head) {
        if (head == null) {
            System.out.println("List empty!");
            return;
        }

        Node curr = head;
        while (curr != null) {
            System.out.print(curr.data + " ");
            curr = curr.next;
        }
    }

    public static void main(String[] args) {
        MergeTwoSortedList m = new MergeTwoSortedList();
        Node head1 = new Node(1);
        Node n2 = new Node(2);
        Node n3 = new Node(3);

        head1.next = n2;
        n2.next = n3;

        Node head2 = new Node(2);
        Node n4 = new Node(4);
        Node n5 = new Node(5);

        head2.next = n4;
        n4.next = n5;

        Node head = m.mergeTwoLists2(head1, head2);
        m.printList(head);
        }
}
