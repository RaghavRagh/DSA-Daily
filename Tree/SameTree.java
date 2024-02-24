// 100
// https://leetcode.com/problems/same-tree/description/

import BinaryTreePack.BinaryTree.TreeNode;

public class SameTree {
    public boolean isSameTree(TreeNode p, TreeNode q) {
        if(p == null && q == null) {
            return true;
        }

        if (p == null || q == null) {
            return false;
        }

        if(p.data == q.data) {
            return isSameTree(p.left, q.left) && isSameTree(p.right, q.right);
        }

        return false;
    }
}
