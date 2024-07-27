import BST.BuildTree;
import BST.Node;

public class ValidateBST {

    private static boolean isValidBST(Node root) {
        return validate(root, Long.MIN_VALUE, Long.MAX_VALUE);
    }

    private static boolean validate(Node root, long min, long max) {
        if (root == null) {
            return true;
        }

        if (root.val >= max || root.val <= min) {
            return false;
        }

        return validate(root.left, min, root.val) && validate(root.right, root.val, max);
    }
    
    public static void main(String[] args) {
        int[] nodes = {2,1,3};
        Node root = null;
        for (int i : nodes) {
            root = new BuildTree().create(root, i);
        }

        System.out.println(isValidBST(root));
    }
}
