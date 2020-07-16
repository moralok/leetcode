package tree.diameter_of_binary_tree;

public class DiameterOfBinaryTree {

    private int diameter = 0;

    public int diameterOfBinaryTree(TreeNode root) {
        maxDepth(root);
        return diameter;
    }

    private int maxDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int left = maxDepth(root.left);
        int right = maxDepth(root.right);
        diameter = Math.max(left + right, diameter);
        return Math.max(left, right) + 1;
    }

    public static void main(String[] args) {
        
    }
    
}