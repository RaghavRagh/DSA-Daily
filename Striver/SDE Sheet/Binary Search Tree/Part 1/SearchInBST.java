import BST.Node;
import BST.BuildTree;

public class SearchInBST {

    private static Node searchBST(Node root, int val) {
        if (root == null) {
            return null;
        }

        if (root.val > val) {
            return searchBST(root.left, val);
        } else if (root.val < val) {
            return searchBST(root.right, val);
        } else {
            return root;
        }
    }

    public static void main(String[] args) {
        int[] nodes = { 4, 2, 1, 3, 7 };
        Node root = null;
        for (int i : nodes) {
            root = new BuildTree().create(root, i);
        }

        Node node = searchBST(root, 3);
        new BuildTree().printInorder(node);
    }
}
