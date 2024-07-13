import java.util.LinkedList;
import java.util.Queue;

import BinaryTree.BuildTree;
import BinaryTree.Node;

public class MirrorTree {

    private static void mirror(Node root) {
        if (root == null) {
            return;
        }

        Queue<Node> q = new LinkedList<>();
        q.add(root);

        while (q.size() > 0) {
            Node curr = q.poll();

            Node temp = curr.left;
            curr.left = curr.right;
            curr.right = temp;

            if (curr.left != null) {
                q.add(curr.left);
            }

            if (curr.right != null) {
                q.add(curr.right);
            }
        }
    }

    private static void printTree(Node root) {
        if (root == null) {
            return;
        }

        System.out.print(root.value + " ");
        printTree(root.left);
        printTree(root.right);
    }
    
    public static void main(String[] args) {
        int[] nodes = { 1, 3, -1, -1, 2, 5, -1, -1, 4, -1, -1 };
        Node root = new BuildTree().buildTree(nodes);
        mirror(root);
        printTree(root);
    }
}
