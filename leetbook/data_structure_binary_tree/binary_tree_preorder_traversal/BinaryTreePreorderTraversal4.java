package leetbook.data_structure_binary_tree.binary_tree_preorder_traversal;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class BinaryTreePreorderTraversal4 {
    public List<Integer> preorderTraversal(TreeNode root) {
        // 迭代，只将右节点推入栈
        List<Integer> ret = new ArrayList<Integer>();
        // 栈
        LinkedList<TreeNode> stack = new LinkedList<>();
        TreeNode node = root;
        while (node != null) {
            ret.add(node.val);
            if (node.right != null) {
                stack.push(node.right);
            }
            if (node.left != null) {
                node = node.left;
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