package tree.maximum_depth_of_binary_tree;

public class MaximumDepthOfBinaryTree {

    public int maxDepth(TreeNode root) {
        // 递归
        if (root == null) {
            return 0;
        }
        return 1 + Math.max(maxDepth(root.left), maxDepth(root.right));
    }

    public static void main(String[] args) {
        
    }
}