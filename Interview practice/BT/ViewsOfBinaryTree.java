import java.util.ArrayList;
import java.util.List;

public class ViewsOfBinaryTree {

    static class Node {
        int data;
        Node left, right;

        Node(int data) {
            this.data = data;
            left = right = null;
        }
    }

    int index = -1;

    private Node buildTree(int[] nodes) {
        index++;
        if (nodes[index] == -1) {
            return null;
        }

        Node newNode = new Node(nodes[index]);
        newNode.left = buildTree(nodes);
        newNode.right = buildTree(nodes);

        return newNode;
    }

    private void printLeftView(Node root, List<Integer> ans, int level) {
        if (root == null)
            return;

        if (level == ans.size()) {
            ans.add(root.data);
        }

        printLeftView(root.left, ans, level + 1);
        printLeftView(root.right, ans, level + 1);
    }

    public static void main(String[] args) {
        int[] nodes = { 1, 2, 4, 5, -1, -1, -1, -1, 3, -1, -1 };
        ViewsOfBinaryTree bt = new ViewsOfBinaryTree();
        Node root = bt.buildTree(nodes);
        List<Integer> ans = new ArrayList<>();
        bt.printLeftView(root, ans, 0);

        System.out.println(ans);
    }
}