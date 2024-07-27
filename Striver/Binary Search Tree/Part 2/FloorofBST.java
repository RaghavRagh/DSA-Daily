import BST.BuildTree;
import BST.Node;

public class FloorofBST {

    private static int floor(Node root, int x) {
        if (root == null) {
            return -1;
        }

        if (root.val == x) {
            return x;
        }

        if (root.val > x) {
            return floor(root.left, x);
        }

        int floorValue = floor(root.right, x);
        return (floorValue <= x && floorValue != -1) ? floorValue : root.val;
    }

    public static void main(String[] args) {
        // int[] nodes = { 2, 81, 42, 66, 45, 87, 90 };
        int[] nodes = { 6, 8, 7, 9 };
        Node root = null;
        for (int i : nodes) {
            root = new BuildTree().create(root, i);
        }

        System.out.println(floor(root, 11));
    }
}