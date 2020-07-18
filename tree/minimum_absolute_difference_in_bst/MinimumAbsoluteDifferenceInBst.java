package tree.minimum_absolute_difference_in_bst;

public class MinimumAbsoluteDifferenceInBst {

    private int minimum = Integer.MAX_VALUE;

    public int getMinimumDifference(TreeNode root) {
        // 不能在递归中计算字数中的最小差（犯错1）
        // 前继和后继都需要（犯错2）
        if (root == null){
            return minimum;
        }
        helper(root);
        return minimum;
    }

    private void helper(TreeNode node) {
        getScuccessor(node);
        getPreceding(node);
        if (node.left != null) {
            helper(node.left);
        }
        if (node.right != null) {
            helper(node.right);
        }
    }

    private void getScuccessor(TreeNode node) {
        TreeNode succ = node.right;
        if (succ == null) {
            return;
        }
        while (succ.left != null) {
            succ = succ.left;
        }
        minimum = Math.min(minimum, succ.val - node.val);
    }

    private void getPreceding(TreeNode node) {
        TreeNode prec = node.left;
        if (prec == null) {
            return;
        }
        while (prec.right != null) {
            prec = prec.right;
        }
        minimum = Math.min(minimum, node.val - prec.val);
    }
}