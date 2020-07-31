package leetbook.data_structure_binary_tree.binary_tree_postorder_traversal;

import java.util.LinkedList;
import java.util.List;

public class BinaryTreePostorderTraversal2 {
    public List<Integer> postorderTraversal(TreeNode root) {
        // 迭代 + 倒序
        LinkedList<Integer> ret = new LinkedList<>();
        LinkedList<TreeNode> stack = new LinkedList<>();
        if (root == null) {
            return ret;
        }
        stack.push(root);
        while (!stack.isEmpty()) {
            TreeNode node = stack.pop();
            ret.addFirst(node.val);
            if (node.left != null) {
                stack.push(node.left);
            }
            if (node.right != null) {
                stack.push(node.right);
            }
        }
        return ret;
    }
}