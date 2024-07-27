import BST.Node;

public class MaxSumBSTinBT {

    static class NodeValue {
        boolean isBST;
        int maxNode, minNode, sum;

        NodeValue(boolean isBST, int maxNode, int minNode, int sum) {
            this.isBST = isBST;
            this.maxNode = maxNode;
            this.minNode = minNode;
            this.sum = sum;
        }
    }

    static int maxSum = 0;

    private static int maxSumBST(Node root) {
        solve(root);
        return maxSum;
    }

    private static NodeValue solve(Node root) {
        if (root == null) {
            return new NodeValue(true, Integer.MIN_VALUE, Integer.MAX_VALUE, 0);
        }

        NodeValue left = solve(root.left);
        NodeValue right = solve(root.right);

        if (left.isBST && right.isBST && root.val > left.maxNode && root.val < right.minNode) {
            int sum = left.sum + right.sum + root.val;
            maxSum = Math.max(sum, maxSum);
            int minNode = Math.min(root.val, left.minNode);
            int maxNode = Math.max(root.val, right.maxNode);
            return new NodeValue(true, maxNode, minNode, sum);
        } else {
            return new NodeValue(false, 0, 0, 0);
        }
    }

    static int index = -1;

    public static Node buildTree(int[] nodes) {
        index++;
        if (nodes[index] == -1) {
            return null;
        }

        Node newNode = new Node(nodes[index]);
        newNode.left = buildTree(nodes);
        newNode.right = buildTree(nodes);

        return newNode; 
    }

    public static void main(String[] args) {
        int[] nodes = { 1, 4, 2, -1, -1, 4, -1, -1, 3, 2, -1, -1, 5, 4, -1, -1, 6, -1, -1 };
        Node root = buildTree(nodes);

        System.out.println(maxSumBST(root));
    }
}
