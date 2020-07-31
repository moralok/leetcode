package leetbook.data_structure_binary_tree.binary_tree_preorder_traversal;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class BinaryTreePreorderTraversal2 {
    public List<Integer> preorderTraversal(TreeNode root) {
        // 迭代
        List<Integer> ret = new ArrayList<Integer>();
        // 栈
        LinkedList<TreeNode> stack = new LinkedList<>();
        if (root == null) {
            return ret;
        }
        stack.push(root);
        while (!stack.isEmpty()) {
            TreeNode tmp = stack.pop();
            ret.add(tmp.val);
            if (tmp.right != null) {
                stack.push(tmp.right);
            }
            if (tmp.left != null) {
                stack.push(tmp.left);
            }
        }
        return ret;
    }
}