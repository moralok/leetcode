package depth_first_search.flatten_binary_tree_to_linked_list;

public class FlattenBinaryTreeToLinkedList {
    public void flatten(TreeNode root) {
        // 巧妙
        while (root != null) {
            if (root.left == null) {
                root = root.right;
            } else {
                TreeNode tmp = root.left;
                while (tmp.right != null) {
                    tmp = tmp.right;
                }
                tmp.right = root.right;
                root.right = root.left;
                root.left = null;
                root = root.right;
            }
        }
    }
}