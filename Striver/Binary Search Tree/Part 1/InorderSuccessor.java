import BST.BuildTree;
import BST.Node;

public class InorderSuccessor {

    private static void findPreSuc(Node root, Node[] pre, Node[] suc, int key) {
        pre[0] = null;
        suc[0] = null;

        findPredecessorAndSuccessor(root, pre, suc, key);
    }

    private static void findPredecessorAndSuccessor(Node root, Node[] pre, Node[] suc, int key) {
        // Bae case
        if (root == null) {
            return;
        }

        // if key is found
        if (root.val == key) {
            // maximum value in left subtree is predecessor
            if (root.left != null) {
                pre[0] = findMaximum(root.left);
            }

            // minimum value in right subtree is successor
            if (root.right != null) {
                suc[0] = findMinimum(root.right);
            }

            return;
        }

        // key is smaller than root
        if (key < root.val) {
            suc[0] = root;
            findPredecessorAndSuccessor(root.left, pre, suc, key);
        } else {
            pre[0] = root;
            findPredecessorAndSuccessor(root.right, pre, suc, key);
        }
    }

    private static Node findMaximum(Node root) {
        while (root.right != null) {
            root = root.right;
        }

        return root;
    }

    private static Node findMinimum(Node root) {
        while (root.left != null) {
            root = root.left;
        }

        return root;
    }

    // TC - o(h)
    // SC - O(h)
    static Node successor = null;

    private static Node inorderSuccessor(Node root, int key) {
        if (root == null) {
            return successor;
        }

        if (root.val > key) {
            successor = root;
            inorderSuccessor(root.left, key);
        } else {
            inorderSuccessor(root.right, key);
        }

        return successor;
    }

    public static void main(String[] args) {
        int[] nodes = { 8, 1, 4, 3, 9, 10 };
        Node root = null;
        for (int i : nodes) {
            root = new BuildTree().create(root, i);
        }

        Node[] pre = new Node[1];
        Node[] suc = new Node[1];
        int key = 10;

        findPreSuc(root, pre, suc, key);

        if (pre[0] != null) {
            System.out.println("Predecessor: " + pre[0].val);
        } else {
            System.out.println("No Predecessor");
        }

        if (suc[0] != null) {
            System.out.println("Successor: " + suc[0].val);
        } else {
            System.out.println("No Successor");
        }
    }
}
