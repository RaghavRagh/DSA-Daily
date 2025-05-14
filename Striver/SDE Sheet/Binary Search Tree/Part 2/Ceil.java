import BST.BuildTree;
import BST.Node;

public class Ceil {

    private static int findCeil(Node root, int key) {
        if (root == null) {
            return -1;            
        }

        if (root.val == key) {
            return key;
        }

        if (root.val < key) {
            return findCeil(root.right, key);
        }
        
        int ceilValue = findCeil(root.left, key);
        return (ceilValue >= key && ceilValue != -1) ? ceilValue : root.val;
    }

    public static void main(String[] args) {
        int[] nodes = { 5, 1, 2, 3, 7 };
        Node root = null;
        for (int i : nodes) {
            root = new BuildTree().create(root, i);
        }

        System.out.println(findCeil(root, 3));
    }
}
