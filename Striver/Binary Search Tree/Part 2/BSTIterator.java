import BST.Node;
import BST.BuildTree;

import java.util.Stack;

public class BSTIterator {

    private Stack<Node> s = new Stack<>();

    public BSTIterator(Node root) {
        pushAll(root);
    }

    public int next() {
        if (s.isEmpty()) {
            return -1;
        }

        Node tempNode = s.pop();
        pushAll(tempNode.right);
        return tempNode.val;
    }

    public boolean hasNext() {
        return !s.isEmpty();
    }

    private void pushAll(Node node) {
        while (node != null) {
            s.push(node);
            node = node.left;
        }
    }

    public static void main(String[] args) {
        int[] nodes = { 7, 3, 15, 9, 30 };
        Node root = null;
        for (int i : nodes) {
            root = new BuildTree().create(root, i);
        }

        BSTIterator bst = new BSTIterator(root);
        System.out.println(bst.hasNext());
        System.out.println(bst.next());
        System.out.println(bst.next());
        System.out.println(bst.next());
        System.out.println(bst.next());
        System.out.println(bst.next());
        System.out.println(bst.hasNext());
        System.out.println(bst.next());
        System.out.println(bst.next());

    }
}
