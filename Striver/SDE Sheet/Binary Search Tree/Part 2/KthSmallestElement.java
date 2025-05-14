import BST.BuildTree;
import BST.Node;

public class KthSmallestElement {

    static int counter = 0;
    static int result = -1;

    private static int kthSmallest(Node root, int k) {
        inorder(root, k);
        return result;
    }

    private static void inorder(Node root, int k) {
        if (root == null) {
            return;
        }

        inorder(root.left, k);
        counter++;

        if (counter == k) {
            result = root.val;
            return;
        }

        inorder(root.right, k);
    }

    public static void main(String[] args) {
        int[] nodes = { 3, 1, 2, 4 };
        Node root = null;
        for (int i : nodes) {
            root = new BuildTree().create(root, i);
        }

        System.out.println(kthSmallest(root, 3));
    }
}
