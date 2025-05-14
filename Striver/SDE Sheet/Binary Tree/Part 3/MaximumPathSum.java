import BinaryTree.BuildTree;
import BinaryTree.Node;

/* 
Approach
1. Recursive Traversal: Use a helper function to traverse the tree recursively.
2. Track Maximum Path: At each node, compute the maximum path sum with three possibilities:
    . Only the left subtree.
    . Only the right subtree.
    . Both left and right subtrees with the current node as the root.
3 Update Global Maximum: Maintain a global variable to track the maximum path sum encountered during the traversal.

Steps
1. Base Case: If the node is null, return 0 (since a null node does not contribute to the path sum).
2. Recursive Case: Compute the maximum path sum for the left and right subtrees.
3. Compute Current Maximum: Calculate the maximum path sum considering the current node as the root.
4. Update Global Maximum: Update the global maximum if the current path sum is greater than the previously recorded maximum.
5. Return Value: For the recursive function, return the maximum path sum considering only one side (left or right) to ensure the path remains valid.
*/

public class MaximumPathSum {

    private static int max;

    private static int maxPathSum(Node root) {
        max = Integer.MIN_VALUE;
        findSum(root);
        return max;
    }

    private static int findSum(Node node) {
        if (node == null) {
            return 0;
        }

        int leftMax = Math.max(0, findSum(node.left));
        int rightMax = Math.max(0, findSum(node.right));

        int currentMax = node.value + leftMax + rightMax;

        max = Math.max(max, currentMax);

        return node.value + Math.max(leftMax, rightMax);
    }
    
    public static void main(String[] args) {
        int[] nodes = { -10, 9, -1, -1, 20, 15, -1, -1, 7, -1, -1 };
        Node root = new BuildTree().buildTree(nodes);
        System.out.println(maxPathSum(root));
    }
}