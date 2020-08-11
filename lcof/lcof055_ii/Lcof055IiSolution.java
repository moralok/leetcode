package lcof.lcof055_ii;

public class Lcof055IiSolution {
    public boolean isBalanced(TreeNode root) {
        // 自顶向下、重复计算深度
        // 先序遍历
        if (root == null) {
            return true;
        }
        return Math.abs(depth(root.left) - depth(root.right)) < 2 && isBalanced(root.left) && isBalanced(root.right);
    }

    private int depth(TreeNode node) {
        if (node == null) {
            return 0;
        }
        return 1 + Math.max(depth(node.left), depth(node.right));
    }
}