package daily;

public class Daily20240203Lc1690Solution {

    public int stoneGameVII(int[] stones) {
        int n = stones.length;
        int[] sum = new int[n + 1];
        int[][] memo = new int[n][n];
        for (int i = 0; i < n; i++) {
            sum[i + 1] = sum[i] + stones[i];
        }
        return dfs(0, n - 1, sum, memo);

    }

    private int dfs(int i, int j, int[] sum, int[][] memo) {
        if (i >= j) {
            return 0;
        }
        if (memo[i][j] != 0) {
            return memo[i][j];
        }
        int res = Math.max(sum[j + 1] - sum[i + 1] - dfs(i + 1, j, sum, memo), sum[j] - sum[i] - dfs(i, j - 1, sum, memo));
        memo[i][j] = res;
        return res;
    }

    public int stoneGameVII2(int[] stones) {
        int n = stones.length;
        int[] sum = new int[n + 1];
        int[][] dp = new int[n][n];

        for (int i = 0; i < n; i++) {
            sum[i + 1] = sum[i] + stones[i];
        }
        for (int i = n - 2; i >= 0; i--) {
            for (int j = i + 1; j < n; j++) {
                dp[i][j] = Math.max(sum[j + 1] - sum[i + 1] - dp[i + 1][j], sum[j] - sum[i] - dp[i][j - 1]);
            }
        }

        return dp[0][n - 1];
    }

    public static void main(String[] args) {
        Daily20240203Lc1690Solution solution = new Daily20240203Lc1690Solution();
        int[] stones = new int[] {5,3,1,4,2};
        assert solution.stoneGameVII(stones) == 6;
        assert solution.stoneGameVII2(stones) == 6;
    }
}
