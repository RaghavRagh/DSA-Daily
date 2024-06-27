import java.util.ArrayList;
import java.util.List;

import BinaryTree.BuildTree;
import BinaryTree.Node;

public class BinaryTreePaths {

    private static List<String> btPaths(Node root) {
        List<String> list = new ArrayList<>();
        solve(root, "", list);
        return list;
    }

    private static void solve(Node root, String path, List<String> list) {
        if (root == null) {
            return;
        }
        
        path += root.value;

        if (root.left == null && root.right == null) {
            list.add(path);
        } else {
            path += "->";
            solve(root.left, path, list);
            solve(root.right, path, list);
        }
    }

    public static void main(String[] args) {
        int[] nodes = { 1, 2, -1, 5, -1, -1, 3, -1, -1 };
        Node root = new BuildTree().buildTree(nodes);
        List<String> res = btPaths(root);
        System.out.println(res);
    }
}
