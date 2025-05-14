import BinaryTree.BuildTree;
import BinaryTree.Node;

public class LowestCommonAncestor {

    /*
     * 4 possible cases
     *
     * 1. current element is equal to a || b.
     * 2. a -> left subtree, b -> right subtree.
     * 3. both a & b in any one subtree.
     * 4. none of a & b in any subtree.
     * 
     */

    private static Node lcs(Node root, int p, int q) {
        if (root == null) {
            return null;
        }

        if (root.value == p || root.value == q) {
            return root;
        }

        Node left = lcs(root.left, p, q);
        Node right = lcs(root.right, p, q);

        if (left == null) {
            return right;
        }

        if (right == null) {
            return left;
        }

        return root;
    }
     
    public static void main(String[] args) {
        int[] nodes = { 3, 5, 6, -1, -1, 2, 7, -1, -1, 4, -1, -1, 1, 0, -1, -1, 8, -1, -1 };
        Node root = new BuildTree().buildTree(nodes);
        System.out.println(lcs(root, 1, 2).value);
    }
}
