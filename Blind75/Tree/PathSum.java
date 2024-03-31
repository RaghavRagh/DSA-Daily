import BinaryTreePack.BinaryTree.TreeNode;

public class PathSum {
    private static boolean hasPathSum(TreeNode root, int k) {
        if (root == null) {
            return false;
        }

        if (root.left == null && root.right == null) {
            return root.data == k;
        }

        return hasPathSum(root.left, k - root.data) || hasPathSum(root.right, k - root.data);
    }
}
