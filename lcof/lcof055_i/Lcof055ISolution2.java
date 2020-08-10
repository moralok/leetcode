package lcof.lcof055_i;

public class Lcof055ISolution2 {

    private int res = 0;

    public int maxDepth(TreeNode root) {
        dfs(root, 0);
        return res;
    }

    private void dfs(TreeNode node, int depth) {
        if (node == null) {
            return;
        }
        depth++;
        if (depth > res) {
            res = depth;
        }
        dfs(node.left, depth);
        dfs(node.right, depth);
    }
}