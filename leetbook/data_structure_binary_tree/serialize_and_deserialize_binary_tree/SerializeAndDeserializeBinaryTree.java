package leetbook.data_structure_binary_tree.serialize_and_deserialize_binary_tree;

import java.util.LinkedList;
import java.util.Queue;

/**
 * bfs
 */
public class SerializeAndDeserializeBinaryTree {

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        StringBuilder sb = new StringBuilder();
        sb.append("[");
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            TreeNode node = queue.poll();
            sb.append(node == null ? "null" : node.val).append(",");
            if (node != null) {
                queue.add(node.left);
                queue.add(node.right);
            }
        }
        String res = sb.toString();
        res = res.substring(0, res.length() - 1) + "]";
        return res;
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        data = data.substring(1, data.length() - 1);
        String[] strs = data.split(",");
        Queue<TreeNode> queue = new LinkedList<>();
        TreeNode root = getTreeNode(strs[0]);
        if (root == null) {
            return null;
        }
        queue.add(root);
        int i = 1;
        while (i < strs.length && !queue.isEmpty()) {
            TreeNode tmp = queue.poll();
            tmp.left = getTreeNode(strs[i]);
            tmp.right = getTreeNode(strs[i + 1]);
            i = i + 2;
            if (tmp.left != null) {
                queue.add(tmp.left);
            }
            if (tmp.right != null) {
                queue.add(tmp.right);
            }
        }
        return root;
    }

    private TreeNode getTreeNode(String val) {
        if (val.equals("null")) {
            return null;
        } else {
            return new TreeNode(Integer.valueOf(val));
        }
    }

    public static void main(String[] args) {
        SerializeAndDeserializeBinaryTree solution = new SerializeAndDeserializeBinaryTree();
        TreeNode node = solution.deserialize("[1,2,3,null,null,4,5,null,null,null,null]");
        String str = solution.serialize(node);
        System.out.println(str);
        return;
    }
}
