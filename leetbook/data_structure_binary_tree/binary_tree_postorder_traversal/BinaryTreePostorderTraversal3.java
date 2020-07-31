package leetbook.data_structure_binary_tree.binary_tree_postorder_traversal;

import java.util.LinkedList;
import java.util.List;

public class BinaryTreePostorderTraversal3 {
    public List<Integer> postorderTraversal(TreeNode root) {
        // 优化迭代（右子节点不入栈） + 倒序
        LinkedList<Integer> ret = new LinkedList<>();
        LinkedList<TreeNode> stack = new LinkedList<>();
        if (root == null) {
            return ret;
        }
        TreeNode node = root;
        while (node != null) {
            ret.addFirst(node.val);
            if (node.left != null) {
                stack.push(node.left);
            }
            if (node.right != null) {
                node = node.right;
            } else {
                if (stack.isEmpty()) {
                    break;
                } else {
                    node = stack.pop();
                }
            }
        }
        return ret;
    }
}