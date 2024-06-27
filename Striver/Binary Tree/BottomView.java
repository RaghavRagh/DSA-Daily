import BinaryTree.BuildTree;
import BinaryTree.Node;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.TreeMap;

class Pair {
    Node value;
    int index;

    Pair(Node value, int index) {
        this.value = value;
        this.index = index;
    }
}

public class BottomView {

    private static ArrayList<Integer> bottomView(Node root) {
        TreeMap<Integer, Node> map = new TreeMap<>();
        Queue<Pair> q = new LinkedList<>();
        ArrayList<Integer> list = new ArrayList<>();

        if (root == null) {
            return list;
        }

        q.add(new Pair(root, 0));

        while (!q.isEmpty()) {
            Pair pair = q.poll();
            Node pairNode = pair.value;
            int pairIndex = pair.index;

            map.put(pairIndex, pairNode);

            if (pairNode.left != null) {
                q.add(new Pair(pairNode.left, pairIndex - 1));
            }

            if (pairNode.right != null) {
                q.add(new Pair(pairNode.right, pairIndex + 1));
            }
        }

        for (Node node : map.values()) {
            list.add(node.value);
        }

        return list;
    }

    public static void main(String[] args) {
        int[] nodes = { 1, 2, 4, -1, 5, -1, 6, -1, -1, -1, 3, 9, -1, -1, 11, 10, -1,
                -1, -1 };
        Node root = new BuildTree().buildTree(nodes);
        ArrayList<Integer> ans = bottomView(root);
        System.out.println(ans);
    }
}