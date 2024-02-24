package BinaryTreePack;

public class BinaryTree {

    public class TreeNode {
        public int data;
        public TreeNode left;
        public TreeNode right;

        public TreeNode(int data) {
            this.data = data;
            this.left = null;
            this.right = null;
        }
    }

    private TreeNode root;

    int idx = -1;
    public TreeNode buildTree(int[] nodes) {
        idx++;
        if (nodes[idx] == -1) {
            return null;
        }

        TreeNode newNode = new TreeNode(nodes[idx]);

        newNode.left = buildTree(nodes);
        newNode.right = buildTree(nodes);

        return newNode;
    }

    public TreeNode getRoot(){
        return root;
    }

    public static void main(String[] args) {
        int nodes[] = { 1, 2, 4, -1, -1, 5, 7, -1, -1, 8, -1, -1, 3, -1, 6, 9, -1, -1, -1 };
        BinaryTree bt = new BinaryTree();
        bt.root = bt.buildTree(nodes);

        System.out.println(bt.root.data);
    }
}
