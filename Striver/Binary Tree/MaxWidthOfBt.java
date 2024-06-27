import java.io.PipedInputStream;
import java.util.LinkedList;
import java.util.Queue;

import BinaryTree.BuildTree;
import BinaryTree.Node;

public class MaxWidthOfBt {

    static class Pair {
        Node node;
        int index;

        Pair(Node node, int index) {
            this.node = node;
            this.index = index;
        }
    }
    
    private static int widthOfBinaryTree(Node root) {
        if (root == null) {
            return 0;
        }

        Queue<Pair> q = new LinkedList<>();
        int maxWidth = 0;

        q.add(new Pair(root, 0));

        while (!q.isEmpty()) {
            int size = q.size();
            int minIndex = q.peek().index;
            int firstIndex = 0, lastIndex = 0;

            for (int i = 0; i < size; i++) {
                Pair current = q.poll();
                int currentIndex = current.index - minIndex;
                Node currNode = current.node;

                if (i == 0) firstIndex = currentIndex;
                if (i == size - 1) lastIndex = currentIndex;

                if (currNode.left != null) {
                    q.add(new Pair(currNode.left, currentIndex * 2 + 1));
                }

                if (currNode.right != null) {
                    q.add(new Pair(currNode.right, currentIndex * 2 + 2));
                }
            }

            maxWidth = Math.max(maxWidth, lastIndex - firstIndex + 1);
        }

        return maxWidth;
    }
    
    public static void main(String[] args) {
        int[] nodes = { 1, 3, 5, 6, -1, -1, -1, -1, 2, -1, 9, 7, -1, -1, -1 };
        Node root = new BuildTree().buildTree(nodes);
        int ans = widthOfBinaryTree(root);
        System.out.println(ans);
    }
}
