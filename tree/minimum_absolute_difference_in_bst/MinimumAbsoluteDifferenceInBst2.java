package tree.minimum_absolute_difference_in_bst;

public class MinimumAbsoluteDifferenceInBst2 {

    private int minimum = Integer.MAX_VALUE;
    private TreeNode prev = null;

    public int getMinimumDifference(TreeNode root) {
        inOrder(root);
        return minimum;
    }

    private void inOrder(TreeNode node) {
        // 使用双指针优化，消除顺序列表的空间成本
        if (node == null) {
            return;
        }
        inOrder(node.left);
        if (prev != null) {
            minimum = Math.min(minimum, node.val - prev.val);
        }
        prev = node;
        inOrder(node.right);
    }
}