package tree.path_sum_iii;

public class PathSumIii {

    private int res = 0;

    public int pathSum(TreeNode root, int sum) {
        // 双重递归
        if (root == null) {
            return 0;
        }
        countSum(root, sum);
        pathSum(root.left, sum);
        pathSum(root.right, sum);
        return res;
    }

    private void countSum(TreeNode root, int sum) {
        if (root == null) {
            return;
        }
        if (sum == root.val) {
            res++;
        }
        countSum(root.left, sum - root.val);
        countSum(root.right, sum - root.val);
    }
}