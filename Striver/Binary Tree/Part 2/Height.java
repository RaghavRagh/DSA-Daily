import BinaryTree.BuildTree;
import BinaryTree.Node;

public class Height {

    private static int getHeight(Node root) {
        if (root == null) {
            return 0;
        }

        int leftHeight = getHeight(root.left);
        int rightHeight = getHeight(root.right);

        return Math.max(leftHeight, rightHeight) + 1;
    }

    public static void main(String[] args) {
        int[] nodes = { 1, 2, -1, -1, 3, 4, 5, 9, -1, -1, -1, -1, 6, -1, 7, -1, 8, -1, -1 };
        Node root = new BuildTree().buildTree(nodes);
        System.out.println(getHeight(root));
    }
}
