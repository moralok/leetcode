package tree.minimum_depth_of_binary_tree;

public class MinimumDepthOfBinaryTree2 {
    public int minDepth(TreeNode root) {
        // 题意理解错误，到叶子节点。因此对于[1, 2]，应该返回2
        // 深度优先遍历，递归返回结果
        // 节点为null，返回0
        if (root == null) {
            return 0;
        }
        // 左右孩子为null，即叶子结点，返回1
        if (root.left == null && root.right == null) {
            return 1;
        }
        int left = minDepth(root.left);
        int right = minDepth(root.right);
        // 如果左右孩子其中一个为null，不是叶子结点，所以取非null子树的最小深度
        // 因为其中一个为0，相加即可
        // 妙啊
        if (root.left == null || root.right == null) {
            return left + right + 1;
        }
        return Math.min(left, right) + 1;
    }
}