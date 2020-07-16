package tree.path_sum;

public class PathSum {
    public boolean hasPathSum(TreeNode root, int sum) {
        return hasPathSum(root, 0, sum);
    }

    private boolean hasPathSum(TreeNode root, int count, int sum) {
        if (root == null) {
            return false;
        }
        count += root.val;
        if (root.left == null && root.right == null) {
            return count == sum;
        }
        return hasPathSum(root.left, count, sum) || hasPathSum(root.right, count, sum);
    }
}