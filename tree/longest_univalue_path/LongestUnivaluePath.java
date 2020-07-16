package tree.longest_univalue_path;

public class LongestUnivaluePath {

    int ans = 0;

    public int longestUnivaluePath(TreeNode root) {
        inOrder(root);
        return ans;
    }

    private int inOrder(TreeNode root) {
        // 用自己的方式写，以为取巧结果犯了好多错
        if (root == null) {
            return 0;
        }
        int leftLen = inOrder(root.left);
        int rightLen = inOrder(root.right);
        int newLeftLen = 0;
        int newRightLen = 0;
        if (root.left != null && root.left.val == root.val) {
            // 如果进入分支，单边要+1 ！！！
            // 否则置为0
            newLeftLen = leftLen + 1;
        }
        if (root.right != null && root.right.val == root.val) {
            newRightLen = rightLen + 1;
        }
        ans = Math.max(ans, newLeftLen + newRightLen);
        return Math.max(newLeftLen, newRightLen);
    }
}