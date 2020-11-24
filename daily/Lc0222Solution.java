package daily;

public class Lc0222Solution {

    private int ret;

    public int countNodes(TreeNode root) {
        dfs(root);
        return ret;
    }

    private void dfs(TreeNode node) {
        if (node == null) {
            return;
        }
        ret++;
        dfs(node.left);
        dfs(node.right);
    }
}