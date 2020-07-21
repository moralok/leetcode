package binary_search_tree.maximum_sum_bst_in_binary_tree;

public class MaximumSumBstInBinaryTree {

    int res = 0;

    public int maxSumBST(TreeNode root) {
        // 递归
        helper(root);
        return res;
    }

    private Result helper(TreeNode node) {
        if (node == null) {
            return new Result(true, Integer.MAX_VALUE, Integer.MIN_VALUE, 0);
        }
        Result leftResult = helper(node.left);
        Result rightResult = helper(node.right);
        if (!(leftResult.isBST && rightResult.isBST && leftResult.max < node.val && rightResult.min > node.val)) {
            return new Result(false, 0, 0, 0);
        }
        // 处理最大最小值，妙
        int min = node.left == null ? node.val : leftResult.min;
        int max = node.right == null ? node.val : rightResult.max;
        int sum = leftResult.sum + rightResult.sum + node.val;
        res = Math.max(res, sum);
        return new Result(true, min, max, sum);
    }

}

class Result {
    boolean isBST;
    int min;
    int max;
    int sum;

    Result(boolean isBST, int min, int max, int sum) {
        this.isBST = isBST;
        this.min = min;
        this.max = max;
        this.sum = sum;
    }
}