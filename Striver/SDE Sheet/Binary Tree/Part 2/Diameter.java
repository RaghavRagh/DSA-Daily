import BinaryTree.BuildTree;
import BinaryTree.Node;

public class Diameter {

    // Tc - O(n)
    static int diameter = 0;
    private static int getDiameter2(Node root) {
        if (root == null) {
            return 0;
        }

        int leftHeight = getDiameter2(root.left);
        int rightHeight = getDiameter2(root.right);

        diameter = Math.max(diameter, leftHeight + rightHeight + 1);

        return Math.max(leftHeight, rightHeight) + 1;
    }

    //TC-O(n^2)
    private static int getDiameter1(Node root) {
        if (root == null) {
            return 0;
        }

        int dl = getDiameter1(root.left);
        int dr = getDiameter1(root.right);

        int curr = height(root.left) + height(root.right) + 1;

        return Math.max(curr, Math.max(dl, dr));
    }

    private static int height(Node root) {
        if (root == null) {
            return 0;
        }

        

        return Math.max(height(root.left), height(root.right)) + 1;
    }

    public static void main(String[] args) {
        // int[] nodes = { 1, 2, -1, -1, 3, 4, 5, 9, -1, -1, -1, -1, 6, -1, 7, -1, 8,
        // -1, -1 };
        int[] nodes = { 3, 2, -1, -1, 4, 1, -1, -1, 5, -1, -1 };
        Node root = new BuildTree().buildTree(nodes);
        System.out.println(getDiameter2(root));
        System.out.println(diameter);
    }
}
