package dynamic_programming;

public class Lc0300Solution {
    public int lengthOfLIS(int[] nums) {
        // 1. 转移方程：dp[i] = max{max{dp[j]} + 1, 1}
        // O(n2)，效率真低啊
        if (nums == null || nums.length == 0) {
            return 0;
        }
        int[] dp = new int[nums.length];
        dp[0] = 1;
        int max = 1;
        for (int i = 1; i < nums.length; i++) {
            dp[i] = 1;
            for (int j = 0; j < i; j++) {
                if (nums[j] < nums[i]) {
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
            }
            max = Math.max(max, dp[i]);
        }
        return max;
    }
}
