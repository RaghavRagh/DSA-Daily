public class MergeTwoSortedList {

    class Node {
        int data;
        Node next;

        Node(int data) {
            this.data = data;
            this.next = null;
        }
    }

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
                list1.next = mergeTwoLists(list1.next, list2);
                return list1;
            } else {
                list2.next = mergeTwoLists(list1, list2.next);
                return list2;
            }
        }

        if (list1 == null)
            return list2;
            
        return list1;
    }
}
