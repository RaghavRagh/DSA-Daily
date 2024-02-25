// 105
// https://leetcode.com/problems/construct-binary-tree-from-preorder-and-inorder-traversal/description/

import java.util.HashMap;
import java.util.Map;

public class ConstructBtFromInorderPreorder {

    static class TreeNode {
        int data;
        TreeNode left, right;

        TreeNode(int data) {
            this.data = data;
            this.left = null;
            this.right = null;
        }
    }

    // Approach 1
    private static TreeNode buildTree(int[] preorder, int[] inorder) {
        Map<Integer, Integer> inorderMap = new HashMap<>();
        for (int i = 0; i < inorder.length; i++) {
            inorderMap.put(inorder[i], i);
        }

        return splitTree(preorder, inorderMap, 0, 0, inorder.length - 1);
    }

    private static TreeNode splitTree(int[] preorder, Map<Integer, Integer> inorderMap, int rootIdx, int left,
            int right) {
        TreeNode root = new TreeNode(preorder[rootIdx]);

        // create left and right subtree
        int mid = inorderMap.get(preorder[rootIdx]);
        if (mid > left) {
            root.left = splitTree(preorder, inorderMap, rootIdx + 1, left, mid - 1);
        }

        if (mid < right) {
            root.right = splitTree(preorder, inorderMap, rootIdx + mid - left + 1, mid + 1, right);
        }

        return root;
    }

    // Approach 2
    private static TreeNode buildTree2(int[] preorder, int[] inorder) {
        int preorderIdx = 0;
        return solve(preorder, inorder, preorderIdx, 0, inorder.length - 1);
    }

    private static TreeNode solve(int[] preorder, int[] inorder, int index, int inorderStart, int inorderEnd) {
        //base case
        if (index >= preorder.length || inorderStart > inorderEnd) {
            return null;
        }

        int element = preorder[index];
        TreeNode root = new TreeNode(element);

        int position = findPosition(inorder, element);

        root.left = solve(preorder, inorder, index + 1, inorderStart, position - 1);
        root.right = solve(preorder, inorder, index + position - inorderStart + 1, position + 1, inorderEnd);

        return root;
    }

    private static int findPosition(int[] inorder, int element) {
        for (int i = 0; i < inorder.length; i++) {
            if (inorder[i] == element) {
                return i;
            }
        }

        return -1;
    }

    private static void printTree(TreeNode root) {
        if (root == null) {
            return;
        }

        System.out.print(root.data + " ");
        printTree(root.left);
        printTree(root.right);
    }

    public static void main(String[] args) {
        int[] preorder = { 3, 9, 20, 15, 7 };
        int[] inorder = { 9, 3, 15, 20, 7 };

        // Approach 1
        // TreeNode root = buildTree(preorder, inorder);
        // printTree(root);

        // Aproach 2
        TreeNode root2 = buildTree2(preorder, inorder);
        printTree(root2);
    }
}
