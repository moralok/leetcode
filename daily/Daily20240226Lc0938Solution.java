package daily;

import common.TreeNode;

public class Daily20240226Lc0938Solution {

    public int rangeSumBST(TreeNode root, int low, int high) {
        return dfs(root, low, high);
    }

    private int dfs(TreeNode node, int low, int high) {
        if (node == null) {
            return 0;
        }
        if (node.val >= low && node.val <= high) {
            return node.val + dfs(node.left, low, high) + dfs(node.right, low, high);
        } else if (node.val < low) {
            return dfs(node.right, low, high);
        } else {
            return dfs(node.left, low, high);
        }
    }
}
