package depth_first_search.flatten_binary_tree_to_linked_list;

import java.util.LinkedList;

public class FlattenBinaryTreeToLinkedList3 {

    public void flatten(TreeNode root) {
        // 先序遍历（另类）
        if (root == null) {
            return;
        }
        LinkedList<TreeNode> stack = new LinkedList<>();
        stack.push(root);
        TreeNode pre = null;
        while (!stack.isEmpty()) {
            TreeNode tmp = stack.pop();
            if (pre != null) {
                pre.right = tmp;
                pre.left = null;
            }
            if (tmp.right != null) {
                stack.push(tmp.right);
            }
            if (tmp.left != null) {
                stack.push(tmp.left);
            }
            pre = tmp;
        }
    }
}