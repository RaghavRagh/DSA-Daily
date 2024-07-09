import java.util.HashMap;

import BinaryTree.Node;

public class ContructBTfromInorderPreorder {

    private static Node constructBt(int[] preorder, int[] inorder) {
        int n = inorder.length;
        int preorderIdx = 0;
        HashMap<Integer, Integer> map = new HashMap<>();
        createMapping(inorder, map, n);
        Node ans = solve(preorder, inorder, preorderIdx, 0, n - 1, map, n);
        return ans;
    }

    private static Node solve(int[] preorder, int[] inorder, int preIdx, int inorderStart, int inorderEnd,
            HashMap<Integer, Integer> map, int n) {
        // base case
        if (preIdx >= n || inorderStart > inorderEnd) {
            return null;
        }

        int element = preorder[preIdx++];
        Node root = new Node(element);
        int position = map.get(element);

        // recursive calls
        root.left = solve(preorder, inorder, preIdx, inorderStart, position - 1, map, n);
        root.right = solve(preorder, inorder, preIdx + position - inorderStart, position + 1, inorderEnd, map, n);  

        return root;
    }

    /*
     * Index Calculation
     * 1. When constructing the left subtree:
     * .The next root in the preorder array will be preorder[preIdx + 1] (since
     * preorder[preIdx] is the current root).
     * 
     * 2. When constructing the right subtree:
     * .We need to skip all the elements that belong to the left subtree in the
     * preorder array.
     * .The number of elements in the left subtree is given by position -
     * inorderStart (where position is the index of the current root in the inorder
     * array).
     * 
     * 3. Therefore, the starting index for the right subtree in the preorder array
     * is:
     * .preIdx + (position - inorderStart) + 1
     * 
     */

    private static void createMapping(int[] inorder, HashMap<Integer, Integer> map, int n) {
        for (int i = 0; i < n; i++) {
            map.put(inorder[i], i);
        }
    }

    private static void printPre(Node root) {
        if (root == null) {
            return;
        }

        System.out.print(root.value + " ");
        printPre(root.left);
        printPre(root.right);
    }

    public static void main(String[] args) {
        int[] preorder = { 3, 9, 20, 15, 7 };
        int[] inorder = { 9, 3, 15, 20, 7 };
        Node root = constructBt(preorder, inorder);
        printPre(root);
    }
}
