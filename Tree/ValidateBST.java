// 98
// https://leetcode.com/problems/validate-binary-search-tree/description/
import BinaryTreePack.BinaryTree.TreeNode;;

public class ValidateBST {

    public boolean isValidBST(TreeNode root) {
        return isValidBST(root, Long.MIN_VALUE, Long.MAX_VALUE);
    }

    private boolean isValidBST(TreeNode root, long minVal, long maxVal) {
        if (root == null) return true;
        if (root.data >= maxVal || root.data <= minVal) return false;
        return isValidBST(root.left, minVal, root.data) && isValidBST(root.right, root.data, maxVal);
    }
}
