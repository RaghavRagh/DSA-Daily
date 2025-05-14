package BST;

public class BuildTree {

    public Node create(Node root, int value) {
        if (root == null) {
            Node newNode = new Node(value);
            return newNode;
        }

        if (value < root.val) {
            root.left = create(root.left, value);
        } else {
            root.right = create(root.right, value);
        }

        return root;
    }

    public void printInorder(Node root) {
        if (root == null) {
            return;
        }

        printInorder(root.left);
        System.out.print(root.val + " ");
        printInorder(root.right);
    }

    public static void main(String[] args) {
        int[] nodes = {8,5,1,7,10,12};
        Node root = null;
        for (int i: nodes) {
            root = new BuildTree().create(root, i);
        }
    }
}
