package tree.minimum_depth_of_binary_tree;

public class MinimumDepthOfBinaryTree4 {

    private int minDepth = Integer.MAX_VALUE;

    public int minDepth(TreeNode root) {
        // 深度遍历优先，获得当前深度，与已有最小深度比较
        // 与递归获取结果有所区别
        if (root == null) {
            return 0;
        }
        inOrder(root, 1);
        return minDepth;
    }

    private void inOrder(TreeNode node, int curDepth) {
        if (node.left == null && node.right == null) {
            minDepth = Math.min(minDepth, curDepth);
        }
        if (node.left != null) {
            inOrder(node.left, curDepth + 1);
        }
        if (node.right != null) {
            inOrder(node.right, curDepth + 1);
        }
    }
}