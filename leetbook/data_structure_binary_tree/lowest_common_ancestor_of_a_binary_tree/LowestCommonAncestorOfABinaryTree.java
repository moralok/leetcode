package leetbook.data_structure_binary_tree.lowest_common_ancestor_of_a_binary_tree;

public class LowestCommonAncestorOfABinaryTree {

    private TreeNode ans = null;

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        // 递归，后序遍历，将状态向上传递
        dfs(root, p, q);
        return ans;
    }

    private boolean dfs(TreeNode node, TreeNode p, TreeNode q) {
        if (node == null) {
            return false;
        }
        boolean left = dfs(node.left, p, q);
        boolean right = dfs(node.right, p, q);
        if ((left && right) || ((left || right) && (node.val == p.val || node.val == q.val))) {
            ans = node;
        }
        return left || right || (node.val == p.val || node.val == q.val);
    }
}
