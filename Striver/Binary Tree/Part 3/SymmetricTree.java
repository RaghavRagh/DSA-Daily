import BinaryTree.Node;
import BinaryTree.BuildTree;

public class SymmetricTree {

    private static boolean isSymmetric(Node root) {
        if (root == null) {
            return true;
        }

        return isMirror(root.left, root.right);
    }

    private static boolean isMirror(Node root1, Node root2) {
        if (root1 == null && root2 == null) {
            return true;
        }

        if (root1 == null || root2 == null) {
            return false;
        }

        if (root1.value == root2.value) {
            return isMirror(root1.left, root2.right) && isMirror(root1.right, root2.left);
        }

        return false;
    }
    
    public static void main(String[] args) {
        int[] nodes = { 1, 2, 3, -1, -1, 4, -1, -1, 2, 4, -1, -1, 3, -1, -1 };
        Node root = new BuildTree().buildTree(nodes);
        System.out.println(isSymmetric(root));
    }
}
