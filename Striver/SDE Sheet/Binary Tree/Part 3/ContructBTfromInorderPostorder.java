import java.util.HashMap;

import BinaryTree.Node;

public class ContructBTfromInorderPostorder {

    private static Node constructBt(int[] inorder, int[] postorder) {
        int n = inorder.length;
        int postIdx = n - 1;
        HashMap<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i < n; i++) {
            map.put(inorder[i], i);
        }

        Node root = solve(inorder, postorder, postIdx, 0, n - 1, map);
        return root;
    }

    private static Node solve(int[] inorder, int[] postorder, int postIdx, int inorderStart, int inorderEnd,
            HashMap<Integer, Integer> map) {
        if (postIdx < 0 || inorderStart > inorderEnd) {
            return null;
        }

        int element = postorder[postIdx--];
        Node root = new Node(element);
        int position = map.get(element);

        root.right = solve(inorder, postorder, postIdx, position + 1, inorderEnd, map);
        root.left = solve(inorder, postorder, postIdx - (inorderEnd - position), inorderStart, position - 1, map);

        return root;
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
        int[] inorder = { 9, 3, 15, 20, 7 };
        int[] postorder = { 9, 15, 7, 20, 3 };
        Node root = constructBt(inorder, postorder);
        printPre(root);
    }
}
