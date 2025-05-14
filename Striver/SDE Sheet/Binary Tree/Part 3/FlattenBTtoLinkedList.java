import java.util.LinkedList;
import java.util.Queue;

import BinaryTree.BuildTree;
import BinaryTree.Node;

public class FlattenBTtoLinkedList {

    // TC - O(n)
    // SC - O(n)
    private static void flatten(Node root) {
        if (root == null) {
            return;
        }

        Queue<Node> q = new LinkedList<>();
        addNodes(root, q);

        Node temp = q.poll();

        while (!q.isEmpty()) {
            temp.left = null;
            temp.right = q.poll();
            temp = temp.right;
        }

        printTree(root);
    }

    private static void addNodes(Node root, Queue<Node> q) {
        if (root == null) {
            return;
        }

        q.add(root);
        addNodes(root.left, q);
        addNodes(root.right, q);
    }

    // TC - O(n)
    // SC - O(1)
    private static void flatten2(Node root) {
        Node curr = root;

        while (curr != null) {
            if (curr.left != null) {
                Node pre = curr.left;

                while (pre.right != null) {
                    pre = pre.right;
                }

                pre.right = curr.right;
                curr.right = curr.left;
                curr.left = null;
            }

            curr = curr.right;
        }
    }

    private static void printTree(Node root) {
        if (root == null) {
            return;
        }

        System.out.print(root.value + " ");
        printTree(root.right);
    }

    public static void main(String[] args) {
        int[] nodes = { 1, 2, 3, -1, -1, 4, -1, -1, 5, -1, 6, -1, -1 };
        // int[] nodes = { 0 };
        Node root = new BuildTree().buildTree(nodes);
        flatten2(root);
        printTree(root);
    }
}
