package leetbook.data_structure_binary_tree.binary_tree_postorder_traversal;

import java.util.ArrayList;
import java.util.List;

public class BinaryTreePostorderTraversal {
    public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> ret = new ArrayList<>();
        postorderTraversal(root, ret);
        return ret;
    }

    private void postorderTraversal(TreeNode root, List<Integer> ret) {
        if (root == null) {
            return;
        }
        postorderTraversal(root.left, ret);
        postorderTraversal(root.right, ret);
        ret.add(root.val);
    }
}