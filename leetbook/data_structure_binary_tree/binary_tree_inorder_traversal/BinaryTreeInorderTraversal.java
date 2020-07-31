package leetbook.data_structure_binary_tree.binary_tree_inorder_traversal;

import java.util.ArrayList;
import java.util.List;

public class BinaryTreeInorderTraversal {

    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> ret = new ArrayList<>();
        inorderTraversal(root, ret);
        return ret;
    }

    private void inorderTraversal(TreeNode root, List<Integer> ret) {
        if (root == null) {
            return;
        }
        inorderTraversal(root.left, ret);
        ret.add(root.val);
        inorderTraversal(root.right, ret);
    }
}