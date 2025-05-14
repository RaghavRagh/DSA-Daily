import BST.BuildTree;
import BST.Node;

public class LCAofBST {

    private static Node lowestCommonAncestor(Node root, Node p, Node q) {
        if (root == null) {
            return null;
        }

        int curr = root.val;

        if (curr > p.val && curr > q.val) {
            lowestCommonAncestor(root.left, p, q);
        }

        if (curr < p.val && curr < q.val) {
            lowestCommonAncestor(root.right, p, q);
        }

        return root;
    }

    public static void main(String[] args) {
        int[] nodes = { 6, 2, 0, 4, 3, 5, 8, 7, 9 };
        Node root = null;
        for (int i : nodes) {
            root = new BuildTree().create(root, i);
        }

        Node p = new Node(2);
        Node q = new Node(8);

        Node lca = lowestCommonAncestor(root, p, q);
        System.out.println(lca.val);
    }
}
