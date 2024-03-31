// 226
// https://leetcode.com/problems/invert-binary-tree/description/

import java.util.LinkedList;
import java.util.Queue;

public class InvertBinaryTree {

    class TreeNode {
        int data;
        TreeNode left, right;

        TreeNode(int data) {
            this.data = data;
            left = right = null;
        }
    }

    // Approach 1 - Recursively
    private TreeNode invertTree(TreeNode root) {
        if (root == null) {
            return null;
        }

        TreeNode left = invertTree(root.left);
        TreeNode right = invertTree(root.right);

        root.left = right;
        root.right = left;

        return root;
    }

    // Approach 2 - Iteratively
    private TreeNode invertTree2(TreeNode root) {
        if(root == null) {
            return null;
        }
        
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);

        while (!q.isEmpty()) {
            TreeNode currNode = q.poll();

            //swapping
            TreeNode temp = currNode.left;
            currNode.left = currNode.right;
            currNode.right = temp;

            if(currNode.left != null) {
                q.add(currNode.left);   
            }

            if(currNode.right != null) {
                q.add(currNode.right);
            }
        }

        return root;
    }

    private void printTree(TreeNode root) {
        if (root == null) {
            return;
        }

        System.out.print(root.data + " ");
        printTree(root.left);
        printTree(root.right);
    }

    public static void main(String[] args) {
        InvertBinaryTree obj = new InvertBinaryTree();
        TreeNode root = obj.new TreeNode(1);
        root.left = obj.new TreeNode(2);
        root.right = obj.new TreeNode(3);

        obj.printTree(root);
        
        TreeNode node = obj.invertTree(root);
        System.out.println();

        obj.printTree(node);
    }
}
