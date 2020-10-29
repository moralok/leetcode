package daily;

public class Lc0129Solution {

    int res = 0;

    public int sumNumbers(TreeNode root) {
        // 深度遍历，题解思路更清晰
        if (root == null) {
            return 0;
        }
        preorder(root, 0);
        return res;
    }

    private void preorder(TreeNode node, int before) {
        int cur = before * 10 + node.val;
        if (node.left == null && node.right == null) {
            res += cur;
        }
        if (node.left != null) {
            preorder(node.left, cur);
        }
        if (node.right != null) {
            preorder(node.right, cur);
        }
    }
}