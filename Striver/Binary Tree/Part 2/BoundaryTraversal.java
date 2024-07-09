import java.util.ArrayList;

import BinaryTree.BuildTree;
import BinaryTree.Node;

public class BoundaryTraversal {

    private static void leftBoundary(Node root, ArrayList<Integer> res) {
        if (root == null || (root.left == null && root.right == null)) {
            return;
        }

        res.add(root.value);

        if (root.left != null) {
            leftBoundary(root.left, res);
        } else {
            leftBoundary(root.right, res);
        }
    }

    private static void rightBoundary(Node root, ArrayList<Integer> res) {
        if (root == null || (root.left == null && root.right == null)) {
            return;
        }

        if (root.right != null) {
            rightBoundary(root.right, res);
        } else {
            rightBoundary(root.left, res);
        }

        res.add(root.value);
    }

    private static void leaves(Node root, ArrayList<Integer> res) {
        if (root == null) {
            return;
        }

        if (root.left == null && root.right == null) {
            res.add(root.value);
            return;
        }

        leaves(root.left, res);
        leaves(root.right, res);
    }

    private static ArrayList<Integer> boundaryTraversal(Node root) {
        ArrayList<Integer> res = new ArrayList<>();
        if (root == null) {
            return res;
        }
        res.add(root.value);

        leftBoundary(root.left, res);

        leaves(root.left, res);
        leaves(root.right, res);

        rightBoundary(root.right, res);

        return res;
    }

    public static void main(String[] args) {
        int[] nodes = { 1, 2, 4, -1, -1, 5, 8, -1, -1, 9, -1, -1, 3, 6, -1, -1, 7, -1, 10, -1, -1 };
        Node root = new BuildTree().buildTree(nodes);
        ArrayList<Integer> result = boundaryTraversal(root);
        System.out.println(result);
    }
}
