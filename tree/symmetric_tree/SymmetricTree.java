package tree.symmetric_tree;

public class SymmetricTree {
    public boolean isSymmetric(TreeNode root) {
        return isSymmetric(root, root);
    }

    private boolean isSymmetric(TreeNode p1, TreeNode p2) {
        if (p1 == null && p2 == null) {
            return true;
        }
        if (p1 == null || p2 == null) {
            return false;
        }
        return p1.val == p2.val && isSymmetric(p1.left, p2.right) && isSymmetric(p1.right, p2.left);
    }
}