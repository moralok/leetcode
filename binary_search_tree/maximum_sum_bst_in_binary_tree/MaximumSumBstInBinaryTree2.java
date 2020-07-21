package binary_search_tree.maximum_sum_bst_in_binary_tree;

public class MaximumSumBstInBinaryTree2 {

    int res = 0;

    public int maxSumBST(TreeNode root) {
        // 发现这个做法也有值得思考的地方
        // 如何判断BST
        helper(root);
        return res;
    }

    private void helper(TreeNode node) {
        if (isBST(node, Integer.MIN_VALUE, Integer.MAX_VALUE)) {
            sumBST(node);
            // 犯错1:忘记return
            return;
        }
        // 犯错2:递归函数调用错误
        helper(node.left);
        helper(node.right);
    }

    private int sumBST(TreeNode node) {
        if (node == null) {
            return 0;
        }
        int sum = node.val + sumBST(node.left) + sumBST(node.right);
        res = Math.max(res, sum);
        return sum;
    }

    private boolean isBST(TreeNode node, int min, int max) {
        // 判断BST，妙
        if (node == null) {
            return true;
        }
        return node.val > min && node.val < max && isBST(node.left, min, node.val) && isBST(node.right, node.val, max);
    }
}