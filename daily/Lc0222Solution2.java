package daily;

public class Lc0222Solution2 {

    public int countNodes(TreeNode root) {
        if (root == null) {
            return 0;
        }
        // 确定层级
        int h = 0;
        TreeNode node = root;
        while (node.left != null) {
            h++;
            node = node.left;
        }
        // 运算符优先级
        int lo = 1 << h, hi = (1 << (h+1)) - 1;
        while (lo < hi) {
            // 二分法的细节很多啊
            int mid = lo + (hi - lo + 1) / 2;
            if (exist(root, h, mid)) {
                lo = mid;
            } else {
                hi = mid - 1;
            }
        }
        return lo;
    }

    private boolean exist(TreeNode root, int h, int k) {
        // !!!还要消化
        int bit = 1 << (h - 1);
        TreeNode node = root;
        while (node != null && bit > 0) {
            if ((k & bit) == 0) {
                node = node.left;
            } else {
                node = node.right;
            }
            bit >>= 1;
        }
        return node != null;
    }
}