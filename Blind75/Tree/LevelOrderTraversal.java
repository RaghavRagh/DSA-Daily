// 102
// https://leetcode.com/problems/binary-tree-level-order-traversal/description/

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class LevelOrderTraversal {

    class Node {
        int data;
        Node left, right;

        public Node(int data) {
            this.data = data;
            this.left = null;
            this.right = null;
        }
    }

    // Build tree
    int idx = -1;

    public Node buildTree(int[] nodes) {
        idx++;
        if (nodes[idx] == -1) {
            return null;
        }

        Node newNode = new Node(nodes[idx]);

        newNode.left = buildTree(nodes);
        newNode.right = buildTree(nodes);

        return newNode;
    }

    // level order traversal
    private List<List<Integer>> levelOrder(Node root) {
        List<List<Integer>> list = new ArrayList<>();

        if (root == null) {
            return list;
        }

        Queue<Node> q = new LinkedList<>();
        q.add(root);

        while (!q.isEmpty()) {
            int size = q.size();
            List<Integer> currLevel = new ArrayList<>();
            while (size-- > 0) {
                Node currNode = q.poll();
                currLevel.add(currNode.data);

                if (currNode.left != null) {
                    q.add(currNode.left);
                }

                if (currNode.right != null) {
                    q.add(currNode.right);
                }
            }

            list.add(currLevel);
        }

        return list;
    }

    public static void main(String[] args) {
        // int[] nodes = { 1, 2, 4, -1, -1, 5, -1, -1, 3, -1, 6, -1, -1 };
        int[] nodes = { 3, 9, -1, -1, 20, 15, -1, -1, 7, -1, -1 };
        LevelOrderTraversal l = new LevelOrderTraversal();
        Node root = l.buildTree(nodes);

        List<List<Integer>> list = l.levelOrder(root);
        list.forEach(System.out::print);
    }
}
