import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

import BinaryTree.BuildTree;
import BinaryTree.Node;

public class ZigzagTraversal {

    private static List<List<Integer>> zigzagLevelOrder(Node root) {
        List<List<Integer>> res = new ArrayList<>();
        if (root == null) {
            return res;
        }

        Queue<Node> q = new LinkedList<>();
        q.offer(root);
        boolean leftToRight = true;

        while (!q.isEmpty()) {
            int levelSize = q.size();
            List<Integer> list = new ArrayList<>(levelSize);

            for (int i = 0; i < levelSize; i++) {
                Node node = q.poll();
                if (leftToRight) {
                    list.add(node.value);
                } else {
                    list.add(0, node.value);
                }

                if (node.left != null) {
                    q.add(node.left);
                }

                if (node.right != null) {
                    q.add(node.right);
                }
            }

            res.add(list);
            leftToRight = !leftToRight;
        }

        return res;
    }

    public static void main(String[] args) {
        int[] nodes = { 3, 9, -1, -1, 20, 15, -1, -1, 7, -1, -1 };
        Node root = new BuildTree().buildTree(nodes);
        List<List<Integer>> list = zigzagLevelOrder(root);
        System.out.println(list);
    }
}
