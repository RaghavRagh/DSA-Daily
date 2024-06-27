import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.TreeMap;

import BinaryTree.BuildTree;
import BinaryTree.Node;

public class VerticalOrder {

    static class Pair {
        Node node;
        int horizontalDistance;
        int level;

        Pair(Node node, int horizontalDistance, int level) {
            this.node = node;
            this.horizontalDistance = horizontalDistance;
            this.level = level;
        }
    }

    private static List<List<Integer>> verticalOrder(Node root) {
        if (root == null) {
            return new ArrayList<>();
        }

        TreeMap<Integer, TreeMap<Integer, PriorityQueue<Integer>>> map = new TreeMap<>();
        Queue<Pair> q = new LinkedList<>();

        q.add(new Pair(root, 0, 0));

        while (!q.isEmpty()) {
            Pair pair = q.poll();
            Node node = pair.node;
            int horizontalDistance = pair.horizontalDistance;
            int level = pair.level;

            map.putIfAbsent(horizontalDistance, new TreeMap<>());
            map.get(horizontalDistance).putIfAbsent(level, new PriorityQueue<>());
            map.get(horizontalDistance).get(level).add(node.value);

            if (node.left != null) {
                q.add(new Pair(node.left, horizontalDistance - 1, level + 1));
            }

            if (node.right != null) {
                q.add(new Pair(node.right, horizontalDistance + 1, level + 1));
            }
        }

        List<List<Integer>> result = new ArrayList<>();
        for (TreeMap<Integer, PriorityQueue<Integer>> levels : map.values()) {
            List<Integer> vertical = new ArrayList<>();
            for (PriorityQueue<Integer> nodes : levels.values()) {
                while (!nodes.isEmpty()) {
                    vertical.add(nodes.poll());
                }
            }
            result.add(vertical);
        }

        return result;
    }

    public static void main(String[] args) {
        int[] nodes = { 3, 1, 0, -1, -1, 2, -1, -1, 4, 2, -1, -1, -1 };
        Node root = new BuildTree().buildTree(nodes);
        List<List<Integer>> ans = verticalOrder(root);
        System.out.println(ans);
    }
}
