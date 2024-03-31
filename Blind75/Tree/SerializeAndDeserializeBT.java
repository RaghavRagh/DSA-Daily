// 297
// https://leetcode.com/problems/serialize-and-deserialize-binary-tree/description/

import java.util.LinkedList;
import java.util.Queue;

import BinaryTreePack.BinaryTree;
import BinaryTreePack.BinaryTree.TreeNode;

public class SerializeAndDeserializeBT {

// Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        if(root == null) {
            return "";
        }

        Queue<TreeNode> q = new LinkedList<>();
        StringBuilder sb = new StringBuilder();
        q.add(root);
        
        while(!q.isEmpty()){
            TreeNode node = q.poll();
            if(node == null) {
                sb.append("n ");
                continue;
            }

            sb.append(node.data + " ");
            q.add(node.left);
            q.add(node.right);
        }

        return sb.toString();
    }
    
    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data, BinaryTree bt) {
        if(data == "") return null;
        Queue<TreeNode> q = new LinkedList<>();
        String[] values = data.split(" ");
        TreeNode root = bt.new TreeNode(Integer.parseInt(values[0]));
        q.add(root);

        for(int i = 1; i < values.length; i++) {
            TreeNode parent = q.poll();
            if(!values[i].equals("n")) {
                TreeNode left = bt.new TreeNode(Integer.parseInt(values[i]));
                parent.left = left;
                q.add(left);
            }

            if(!values[++i].equals("n")) {
                TreeNode right = bt.new TreeNode(Integer.parseInt(values[i]));
                parent.right = right;
                q.add(right);
            }
        }

        return root;
    }

    public static void main(String[] args) {
        int[] nodes = { 1, 2, -1, -1, 3, 4, -1, -1, 5, -1, -1 };
        BinaryTree bt = new BinaryTree();
        TreeNode root = bt.buildTree(nodes);

        SerializeAndDeserializeBT obj = new SerializeAndDeserializeBT();
        String ser = obj.serialize(root);
        System.out.println("Serialized tree -> " + ser);

        obj.deserialize(ser, bt);
    }
}
