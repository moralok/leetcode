package daily;

public class Daily20240325Lc0518Solution {

    public int change(int amount, int[] coins) {
        int[] dp = new int[amount + 1];
        // 初始化为 1，因为不选硬币也是一种方案
        dp[0] = 1;
        // 递推
        for (int coin : coins) {
            for (int i = coin; i <= amount; i++) {
                dp[i] += dp[i - coin];
            }
        }
        return dp[amount];
    }

    public static void main(String[] args) {
        Daily20240325Lc0518Solution solution = new Daily20240325Lc0518Solution();
        assert solution.change(5, new int[]{1, 2, 5}) == 4;
        assert solution.change(3, new int[]{2}) == 0;
        assert solution.change(10, new int[]{10}) == 1;
    }
}
