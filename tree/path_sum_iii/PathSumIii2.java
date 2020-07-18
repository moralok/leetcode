package tree.path_sum_iii;

import java.util.HashMap;
import java.util.Map;

public class PathSumIii2 {

    public int pathSum(TreeNode root, int sum) {
        Map<Integer, Integer> prefixSumCount = new HashMap<>();
        prefixSumCount.put(0, 1);
        return helper(root, sum, prefixSumCount, 0);
    }

    private int helper(TreeNode root, int sum, Map<Integer, Integer> prefixSumCount, int total) {
        if (root == null) {
            return 0;
        }
        int res = 0;
        // 统计根节点到本节点的和
        total += root.val;
        res += prefixSumCount.getOrDefault(total - sum, 0);
        // 更新prefixSumCount
        prefixSumCount.put(total, prefixSumCount.getOrDefault(total, 0) + 1);
        res += helper(root.left, sum, prefixSumCount, total);
        res += helper(root.right, sum, prefixSumCount, total);
        // 递归结束恢复prefixSumCount
        prefixSumCount.put(total, prefixSumCount.get(total) - 1);
        return res;
    }
}