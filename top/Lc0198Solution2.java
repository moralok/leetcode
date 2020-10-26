package top;

public class Lc0198Solution2 {
    public int rob(int[] nums) {
        // 动态规划，有办法将边界条件优化为普通情况
        if (nums == null || nums.length == 0) {
            return 0;
        }
        int pre = 0, cur = 0;
        for (int i = 0; i < nums.length; i++) {
            int tmp = cur;
            cur = Math.max(cur, pre + nums[i]);
            pre = tmp;
        }
        return cur;
    }
}
