package daily;

public class Daily20240324Lc0322Solution {

    public int coinChange(int[] coins, int amount) {
        int[] dp = new int[amount + 1];
        // 初始化为 amount + 1，因为最多需要 amount 个 1 元硬币
        for (int i = 1; i < dp.length; i++) {
            dp[i] = amount + 1;
        }
        dp[0] = 0;
        // 递推
        for (int i = 1; i <= amount; i++) {
            for (int coin : coins) {
                if (i - coin >= 0) {
                    dp[i] = Math.min(dp[i], dp[i - coin] + 1);
                }
            }
        }
        return dp[amount] == amount + 1 ? -1 : dp[amount];
    }

    public int coinChange1(int[] coins, int amount) {
        if (amount == 0) {
            return 0;
        }
        int[] mem = new int[amount + 1];
        return coinChange(coins, amount, mem);
    }

    private int coinChange(int[] coins, int amount, int[] mem) {
        if (amount < 0) {
            return -1;
        }
        if (amount == 0) {
            return 0;
        }
        if (mem[amount] != 0) {
            return mem[amount];
        }
        int min = Integer.MAX_VALUE;
        for (int coin : coins) {
            int sub = coinChange(coins, amount - coin, mem);
            if (sub == -1) {
                continue;
            }
            min = Math.min(min, sub + 1);
        }
        mem[amount] = min == Integer.MAX_VALUE ? -1 : min;
        return mem[amount];
    }

    public static void main(String[] args) {
        Daily20240324Lc0322Solution solution = new Daily20240324Lc0322Solution();
        assert solution.coinChange(new int[]{1, 2, 5}, 11) == 3;
        assert solution.coinChange(new int[]{2}, 3) == -1;
        assert solution.coinChange(new int[]{1}, 0) == 0;
        assert solution.coinChange(new int[]{1}, 1) == 1;
        assert solution.coinChange(new int[]{1}, 2) == 2;

        assert solution.coinChange1(new int[]{1, 2, 5}, 11) == 3;
        assert solution.coinChange1(new int[]{2}, 3) == -1;
        assert solution.coinChange1(new int[]{1}, 0) == 0;
        assert solution.coinChange1(new int[]{1}, 1) == 1;
        assert solution.coinChange1(new int[]{1}, 2) == 2;
    }
}
