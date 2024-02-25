package daily;

import common.TreeNode;

public class Daily20240225Lc0235Solution {

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        TreeNode left = p.val <= q.val ? p : q;
        TreeNode right = p.val <= q.val ? q : p;
        return dfs(root, left, right);
    }

    private TreeNode dfs(TreeNode node, TreeNode left, TreeNode right) {
        if (node == null) {
            return null;
        }
        if (node.val >= left.val && node.val <= right.val) {
            return node;
        }
        if (node.val < left.val) {
            return dfs(node.right, left, right);
        } else {
            return dfs(node.left, left, right);
        }
    }

    public TreeNode lowestCommonAncestor1(TreeNode root, TreeNode p, TreeNode q) {
        TreeNode ancestor = root;
        while (true) {
            if (ancestor.val < p.val && ancestor.val < q.val) {
                ancestor = ancestor.right;
            } else if (ancestor.val > p.val && ancestor.val > q.val) {
                ancestor = ancestor.left;
            } else {
                break;
            }
        }
        return ancestor;
    }
}
