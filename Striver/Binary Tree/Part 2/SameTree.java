import BinaryTree.BuildTree;
import BinaryTree.Node;

public class SameTree {

    private static boolean isSameTree(Node root1, Node root2) {
        if (root1 == null && root2 == null) {
            return true;
        }

        if (root1 == null || root2 == null) {
            return false;
        }

        if (root1.value == root2.value) {
            return isSameTree(root1.left, root2.left) && isSameTree(root1.right, root2.right);
        }

        return false;
    }

    public static void main(String[] args) {
        int[] nodes1 = { 1, 2, -1, -1, 3, -1, -1 };
        int[] nodes2 = { 1, 2, -1, -1, 2, -1, -1 };
        Node root1 = new BuildTree().buildTree(nodes1);
        Node root2 = new BuildTree().buildTree(nodes2);

        System.out.println(isSameTree(root1, root2));
    }
}