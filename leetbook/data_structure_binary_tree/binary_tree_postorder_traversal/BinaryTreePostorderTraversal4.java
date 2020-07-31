package leetbook.data_structure_binary_tree.binary_tree_postorder_traversal;

import java.util.LinkedList;
import java.util.List;

public class BinaryTreePostorderTraversal4 {
    public List<Integer> postorderTraversal(TreeNode root) {
        // 迭代 + 倒序
        LinkedList<Integer> ret = new LinkedList<>();
        LinkedList<TreeNode> stack = new LinkedList<>();
        if (root == null) {
            return ret;
        }
        TreeNode node = root;
        while (node != null || !stack.isEmpty()) {
            if (node != null) {
                stack.push(node);
                ret.addFirst(node.val);
                node = node.right;
            } else {
                node = stack.pop();
                node = node.left;
            }
        }
        return ret;
    }
}