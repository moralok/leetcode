package lcof.lcof027;

public class Lcof027Solution {
    public TreeNode mirrorTree(TreeNode root) {
        // 递归
        if (root == null) {
            return root;
        }
        TreeNode left = mirrorTree(root.right);
        TreeNode right = mirrorTree(root.left);
        root.left = left;
        root.right = right;
        return root;
    }
}