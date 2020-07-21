package binary_search_tree.binary_search_tree_to_greater_sum_tree;

public class BinarySearchTreeToGreaterSumTree {

    private int sum = 0;

    public TreeNode bstToGst(TreeNode root) {
        // 反向中序遍历
        inOrder(root);
        return root;
    }

    private void inOrder(TreeNode node) {
        if (node == null) {
            return;
        }
        inOrder(node.right);
        sum += node.val;
        node.val = sum;
        inOrder(node.left);
    }
}