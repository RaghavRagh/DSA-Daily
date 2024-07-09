package BinaryTree;

public class BuildTree {
    int index = -1;

    public Node buildTree(int[] nodes) {
        index++;
        if (nodes[index] == -1) {
            return null;
        }

        Node newNode = new Node(nodes[index]);
        newNode.left = buildTree(nodes);
        newNode.right = buildTree(nodes);

        return newNode;
    }

    // public void printPreorder(Node root) {
    //     if (root == null) {
    //         return;
    //     }

    //     System.out.print(root.value + " ");
    //     printPreorder(root.left);
    //     printPreorder(root.right);
    // }
}
