package tree.find_mode_in_binary_search_tree;

public class FindModeInBinarySearchTree {

    private TreeNode pre = null;

    private int maxCount = 0;

    private int curCount = 0;

    private int resCount = 0;

    private int[] res;
    
    public int[] findMode(TreeNode root) {
        // 第一次遍历确定结果集大小
        inOrder(root);
        // maxCount 不清零
        pre = null;
        curCount = 0;
        // 第二次遍历的标志
        res = new int[resCount];
        resCount = 0;
        // 第二次遍历
        inOrder(root);
        return res;
    }

    private void inOrder(TreeNode node) {
        if (node == null) {
            return;
        }
        inOrder(node.left);
        if (pre != null && node.val == pre.val) {
            curCount++;
        } else {
            curCount = 1;
        }
        if (curCount > maxCount) {
            maxCount = curCount;
            resCount = 1;
        } else if (curCount == maxCount) {
            if (res != null) {
                res[resCount] = node.val;
            }
            resCount++;
        }
        // 更新pre
        pre = node;
        inOrder(node.right);
    }
}