import BinaryTreePack.BinaryTree;
import BinaryTreePack.BinaryTree.TreeNode;

public class LowestCommonAncestorOfBST {
    public static TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null) {
            return null;
        }

        int curr = root.data;

        if (curr < p.data && curr < q.data) {
            return lowestCommonAncestor(root.right, p, q);
        }

        if (curr > p.data && curr > q.data) {
            return lowestCommonAncestor(root.left, p, q);
        }

        return root;
    }

    public static void main(String[] args) {
        int[] nodes = { 6, 2, 0, -1, -1, 4, 3, -1, -1, 5, -1, -1, 8, 7, -1, -1, 9, -1, -1 };
        BinaryTree bt = new BinaryTree();
        TreeNode root = bt.buildTree(nodes);
        
        TreeNode p = bt.new TreeNode(2);
        TreeNode q = bt.new TreeNode(4);

        TreeNode ans = lowestCommonAncestor(root, p, q);
        System.out.println(ans.data);
    }
}
