import BinaryTree.BuildTree;
import BinaryTree.Node;

public class ChildrenSuminBT {

    private static int isSumProperty(Node root) {
        // Base case: An empty tree or a leaf node satisfies the property
        if (root == null || (root.left == null && root.right == null)) {
            return 1;
        }

        int leftSum = (root.left != null) ? root.left.value : 0;
        int rightSum = (root.right != null) ? root.right.value : 0;

        boolean rootSum = leftSum + rightSum == root.value;
        
        if (rootSum && isSumProperty(root.left) == 1 && isSumProperty(root.right) == 1) {
            return 1;
        } else {
            return 0;
        }
    }

    public static void main(String[] args) {
        int[] nodes = { 35, 20, 15, -1, -1, 5, -1, -1, 15, 10, -1, -1, 4, -1, -1 };
        Node root = new BuildTree().buildTree(nodes);
        System.out.println(isSumProperty(root));
    }
}
