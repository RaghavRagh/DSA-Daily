import javax.swing.tree.TreeNode;

import BinaryTree.BuildTree;
import BinaryTree.Node;

public class BalancedBT {

    // TC - O(n^2)
    private static boolean isBalanced(Node root) {
        if (root == null) {
            return true;
        }

        boolean left = isBalanced(root.left);
        boolean right = isBalanced(root.right);

        boolean diff = Math.abs(height(root.left) - height(root.right)) <= 1;

        if (left && right && diff) {
            return true;
        } else {
            return false;
        }
    }

    private static int height(Node root) {
        if (root == null) {
            return 0;
        }

        return Math.max(height(root.left), height(root.right)) + 1;
    }

    // TC-O(n)
    public static boolean isBalanced2(Node root) {
        if (root == null)
            return true;

        if (Height(root) == -1)
            return false;
        return true;
    }

    public static int Height(Node root) {
        if (root == null)
            return 0;

        int leftHeight = Height(root.left);
        int rightHight = Height(root.right);

        if (leftHeight == -1 || rightHight == -1)
            return -1;
        if (Math.abs(leftHeight - rightHight) > 1)
            return -1;

        return Math.max(leftHeight, rightHight) + 1;
    }

    // TC - O(n)
    private static class HeightBalanceStatus {
        int height;
        boolean isBalanced;

        HeightBalanceStatus(int height, boolean isBalanced) {
            this.height = height;
            this.isBalanced = isBalanced;
        }
    }

    private static boolean isBalanced3(Node root) {
        return checkBalanced(root).isBalanced;
    }

    private static HeightBalanceStatus checkBalanced(Node root) {
        if (root == null) {
            return new HeightBalanceStatus(0, true);
        }

        HeightBalanceStatus left = checkBalanced(root.left);
        HeightBalanceStatus right = checkBalanced(root.right);

        boolean isBalanced = left.isBalanced && right.isBalanced && Math.abs(left.height - right.height) <= 1;

        int height = Math.max(left.height, right.height) + 1;

        return new HeightBalanceStatus(height, isBalanced);
    }

    public static void main(String[] args) {
        int[] nodes = { 3, 9, -1, -1, 20, 15, -1, -1, 7, 8, -1, -1, 4, -1, -1 };
        Node root = new BuildTree().buildTree(nodes);
        // System.out.println(isBalanced(root));
        System.out.println(isBalanced2(root));
    }
}
