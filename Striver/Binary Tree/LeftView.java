import Node.Node;

import java.util.ArrayList;

public class LeftView {

    private static ArrayList<Integer> leftView(Node root) {
        ArrayList<Integer> list = new ArrayList<>();
        solve(root, list);
        return list;
    }

    private static void solve(Node root, ArrayList<Integer> list) {
        if (root == null) return;
        
        list.add(root.value);
        solve(root.left, list);
    }

    public static void main(String[] args) {
        Node root = new Node(10);
        root.left = new Node(20);
        root.right = new Node(30);

        root.left.left = new Node(40);
        root.left.right = new Node(60);

        ArrayList<Integer> list = leftView(root);
        System.out.println(list);
    }
}