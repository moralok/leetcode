package tree.invert_binary_tree;

public class InvertBinaryTree {
    
    public TreeNode invertTree(TreeNode root) {
        // 递归
        if (root == null) {
            return null;
        }
        TreeNode left = invertTree(root.left);
        TreeNode right = invertTree(root.right);
        root.left = right;
        root.right = left;
        return root;
    }

    public static void main(String[] args) {
        
    }
}