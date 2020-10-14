package leetbook.data_structure_binary_tree.serialize_and_deserialize_binary_tree;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * dfs
 */
public class SerializeAndDeserializeBinaryTree2 {

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        StringBuilder sb = new StringBuilder();
        serialize(root, sb);
        return sb.toString();
    }

    private void serialize(TreeNode root, StringBuilder sb) {
        if (root == null) {
            sb.append("null,");
        } else {
            sb.append(root.val).append(",");
            serialize(root.left, sb);
            serialize(root.right, sb);
        }
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        String[] strs = data.split(",");
        if (strs == null || strs.length == 0) {
            return null;
        }
        List<String> dataArr = new LinkedList<>(Arrays.asList(strs));
        return deserialize(dataArr);
    }

    private TreeNode deserialize(List<String> dataArr) {
        if (dataArr.get(0).equals("null")) {
            dataArr.remove(0);
            return null;
        }
        TreeNode node = new TreeNode(Integer.valueOf(dataArr.get(0)));
        dataArr.remove(0);
        node.left = deserialize(dataArr);
        node.right = deserialize(dataArr);
        return node;
    }

    public static void main(String[] args) {
        SerializeAndDeserializeBinaryTree2 solution = new SerializeAndDeserializeBinaryTree2();
        TreeNode node = solution.deserialize("1,2,3,null,null,4,5,null,null,null,null,");
        String str = solution.serialize(node);
        System.out.println(str);
        return;
    }
}
