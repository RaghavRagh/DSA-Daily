import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.TreeMap;

import BinaryTree.BuildTree;
import BinaryTree.Node;

public class TopView {

    private static ArrayList<Integer> topView(Node root) {
        ArrayList<Integer> list = new ArrayList<>();
        if (root == null) {
            return list;
        }

        TreeMap<Integer, Integer> map = new TreeMap<>();
        Queue<Pair> q = new LinkedList<>();

        q.add(new Pair(root, 0));

        while (!q.isEmpty()) {
            Pair pair = q.poll();
            int index = pair.index;
            int data = pair.value.value;

            if (!map.containsKey(index)) {
                map.put(index, data);
            }

            if (pair.value.left != null) {
                q.add(new Pair(pair.value.left, index - 1));
            }

            if (pair.value.right != null) {
                q.add(new Pair(pair.value.right, index + 1));
            }
        }

        for (int i : map.values()) {
            list.add(i);
        }

        return list;
    }
        
    public static void main(String[] args) {
        int[] nodes = { 1, 2, 4, -1, 5, -1, 6, -1, -1, -1, 3, 9, -1, -1, 11, 10, -1,
                -1, -1 };
        Node root = new BuildTree().buildTree(nodes);
        ArrayList<Integer> ans = topView(root);
        System.out.println(ans);
    }
}
