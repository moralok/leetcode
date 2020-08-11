package lcof.lcof055_ii;

public class Lcof055IiSolution2 {
    public boolean isBalanced(TreeNode root) {
        return helper(root) == -1 ? false : true;
    }

    private int helper(TreeNode node) {
        if (node == null) {
            return 0;
        }
        int left = helper(node.left);
        if (left == -1) {
            return -1;
        }
        int right = helper(node.right);
        if (right == -1) {
            return -1;
        }
        if (Math.abs(left - right) >= 2) {
            return -1;
        }
        return 1 + Math.max(left, right);
    }
}