package lcof.lcof054;

public class Lcof054Solution2 {

    private int count;
    private int res;

    public int kthLargest(TreeNode root, int k) {
        // 避免多余的查找
        this.count = k;
        dfs(root);
        return res;
    }

    private void dfs(TreeNode node) {
        // 估计自己写，不会立即注意到count为0要返回
        if (node == null || count == 0) {
            return;
        }
        dfs(node.right);
        if (--count == 0) {
            res = node.val;
            return;
        }
        dfs(node.left);
    }
}