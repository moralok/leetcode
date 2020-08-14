package lcof.lcof037;

import java.util.LinkedList;

public class Lcof037Solution {
    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        if (root == null) {
            return "[]";
        }
        StringBuilder sb = new StringBuilder();
        sb.append("[");
        LinkedList<TreeNode> queue = new LinkedList<>();
        queue.addLast(root);
        while (!queue.isEmpty()) {
            TreeNode node = queue.poll();
            sb.append(node == null ? "null" : node.val).append(",");
            if (node != null) {
                queue.addLast(node.left);
                queue.addLast(node.right);
            }
        }
        String res = sb.toString();
        // 这个地方用错了。。。
        res = res.substring(0, res.length() - 1) + "]";
        return res;
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        if (data.equals("[]")) {
            return null;
        }
        data = data.substring(1, data.length() - 1);
        String[] strs = data.split(",");
        LinkedList<TreeNode> queue = new LinkedList<>();
        TreeNode root = new TreeNode(Integer.parseInt(strs[0]));
        queue.add(root);
        int i = 1;
        while (i < strs.length && !queue.isEmpty()) {
            TreeNode tmp = queue.poll();
            if (!strs[i].equals("null")) {
                tmp.left = new TreeNode(Integer.parseInt(strs[i]));
                queue.addLast(tmp.left);
            }
            i++;
            if (!strs[i].equals("null")) {
                tmp.right = new TreeNode(Integer.parseInt(strs[i]));
                queue.addLast(tmp.right);
            }
            i++;
        }
        return root;
    }

    public static void main(String[] args) {
        String strs = "[1,2,3,null,null,4,5]";
        Lcof037Solution solution = new Lcof037Solution();
        solution.deserialize(strs);
    }
}