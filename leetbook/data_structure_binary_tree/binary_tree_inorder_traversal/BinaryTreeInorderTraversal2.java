package leetbook.data_structure_binary_tree.binary_tree_inorder_traversal;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class BinaryTreeInorderTraversal2 {

    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> ret = new ArrayList<>();
        LinkedList<TreeNode> stack = new LinkedList<>();
        TreeNode node = root;
        while (node != null || !stack.isEmpty()) {
            while (node != null) {
                stack.push(node);
                node = node.left;
            }
            node = stack.pop();
            ret.add(node.val);
            // 这个有点巧妙，怎么想到的呢
            node = node.right;
        }
        return ret;
    }
}