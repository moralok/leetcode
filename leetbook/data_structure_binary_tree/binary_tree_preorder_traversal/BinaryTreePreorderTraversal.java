package leetbook.data_structure_binary_tree.binary_tree_preorder_traversal;

import java.util.ArrayList;
import java.util.List;

public class BinaryTreePreorderTraversal {
    public List<Integer> preorderTraversal(TreeNode root) {
        // 递归
        List<Integer> ret = new ArrayList<Integer>();
        preorderTraversal(root, ret);
        return ret;
    }

    private void preorderTraversal(TreeNode root, List<Integer> ret) {
        if (root == null) {
            return;
        }
        ret.add(root.val);
        preorderTraversal(root.left, ret);
        preorderTraversal(root.right, ret);
    }
}