package depth_first_search.flatten_binary_tree_to_linked_list;

public class FlattenBinaryTreeToLinkedList2 {
    private TreeNode pre = null;

    public void flatten(TreeNode root) {
        // 反向后序遍历
        if (root == null) {
            return;
        }
        flatten(root.right);
        flatten(root.left);
        root.right = pre;
        root.left = null;
        pre = root;
    }
}