
// 98
// https://leetcode.com/problems/validate-binary-search-tree/description/
import BinaryTreePack.BinaryTree;
import BinaryTreePack.BinaryTree.TreeNode;

public class ValidateBST {

    // Approach 1
    public boolean isValidBST(TreeNode root) {
        return isValidBST(root, Long.MIN_VALUE, Long.MAX_VALUE);
    }

    private boolean isValidBST(TreeNode root, long minVal, long maxVal) {
        if (root == null)
            return true;
        if (root.data >= maxVal || root.data <= minVal)
            return false;
        return isValidBST(root.left, minVal, root.data) && isValidBST(root.right, root.data, maxVal);
    }

    // Approach 2
    TreeNode prev = null;
    private boolean isValidBST2(TreeNode root) {
        if (root != null) {
            if (!isValidBST2(root.left)) {
                return false;
            }

            if (prev != null && root.data <= prev.data) {
                return false;
            }

            prev = root;
            return isValidBST2(root.right);
        }

        return true;
    }

    public static void main(String[] args) {
        int[] nodes = { 5, 1, -1, -1, 4, 3, -1, -1, 6, -1, -1 };
        BinaryTree bt = new BinaryTree();
        TreeNode root = bt.buildTree(nodes);

        ValidateBST obj = new ValidateBST();
        boolean ans1 = obj.isValidBST(root);
        System.out.println(ans1);

        boolean ans2 = obj.isValidBST2(root);
        System.out.println(ans2);
    }
}
