import BST.Node;

public class ConvertSortedArrToBST {

    private static Node create(int[] nodes) {
        return createBST(nodes, 0, nodes.length - 1);
    }

    private static Node createBST(int[] nodes, int l, int r) {
        if (l > r) {
            return null;
        }

        int mid = (l + r) / 2;
        Node root = new Node(nodes[mid]);
        root.left = createBST(nodes, l, mid - 1);
        root.right = createBST(nodes, mid + 1, r);

        return root;
    }

    private static void printTree(Node root) {
        if (root == null) {
            return;
        }

        System.out.println(root.val);
        printTree(root.left);
        printTree(root.right);
    }
    
    public static void main(String[] args) {
        int[] nodes = {-10,-3,0,5,9};
        Node root = create(nodes);
        printTree(root);
    }
}
