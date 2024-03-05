// 124
// https://leetcode.com/problems/binary-tree-maximum-path-sum/description/

import BinaryTreePack.BinaryTree;
import BinaryTreePack.BinaryTree.TreeNode;

public class MaximumPathSum {

    public int maxPathSum(TreeNode root) {
        int[] maxValue = new int[1];
        maxValue[0] = Integer.MIN_VALUE;
        maxPathDown(root, maxValue);
        return maxValue[0];
    }

    public int maxPathDown(TreeNode node, int[] maxValue) {
        if (node == null) {
            return 0;
        }

        int left = Math.max(0, maxPathDown(node.left, maxValue));
        int right = Math.max(0, maxPathDown(node.right, maxValue));
        maxValue[0] = Math.max(maxValue[0], left + right + node.data);
        return Math.max(left, right) + node.data;
    }

    public static void main(String[] args) {
        int[] nodes = { -10, 9, -1, -1, 20, 15, -1, -1, 7, -1, -1 };
        BinaryTree bt = new BinaryTree();
        TreeNode root = bt.buildTree(nodes);

        MaximumPathSum obj = new MaximumPathSum();
        int ans = obj.maxPathSum(root);
        System.out.println(ans);
    }
}
