import BST.BuildTree;
import BST.Node;

public class KthLargestElement {

    static int counter = 0;
    static int result = -1;

    private static int kthLargest(Node root, int k) {
        reverseInorder(root, k);
        return result;
    }

    private static void reverseInorder(Node root, int k) {
        if (root == null) {
            return;
        }

        reverseInorder(root.right, k);
        counter++;
        
        if (counter == k) {
            result = root.val;
            return;
        }
        
        reverseInorder(root.left, k);
    }

    public static void main(String[] args) {
        int[] nodes = { 3, 1, 2, 4 };
        Node root = null;
        for (int i : nodes) {
            root = new BuildTree().create(root, i);
        }

        System.out.println(kthLargest(root, 3));
    }
}
