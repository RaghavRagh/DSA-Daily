// 104
// https://leetcode.com/problems/maximum-depth-of-binary-tree/description/

import BinaryTreePack.BinaryTree;

public class MaxDepthOfBinaryTree {

    BinaryTree bt = new BinaryTree();
    
    public int maxDepth(BinaryTree.TreeNode root) {

        if(root == null) {
            return 0;
        }
        
        int leftHeight = maxDepth(root.left);
        int rightHeight = maxDepth(root.right);

        return Math.max(leftHeight, rightHeight) + 1;
    }
    
    public static void main(String[] args) {
        int nodes[] = { 1, 2, 4, -1, -1, 5, 7, -1, -1, 8, -1, -1, 3, -1, 6, 9, -1, -1, -1 };
        BinaryTree bt = new BinaryTree();
        BinaryTree.TreeNode root = bt.buildTree(nodes);
        
        // root = bt.getRoot();
        MaxDepthOfBinaryTree m = new MaxDepthOfBinaryTree();
        int depth = m.maxDepth(root);
        System.out.println(depth);
    }
}
