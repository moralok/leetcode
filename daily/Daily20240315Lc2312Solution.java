package daily;

public class Daily20240315Lc2312Solution {

    public long sellingWood(int m, int n, int[][] prices) {
        long[][] dp = new long[m + 1][n + 1];
        for (int[] price : prices) {
            dp[price[0]][price[1]] = price[2];
        }
        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                for (int k = 1; k <= i / 2; k++) {
                    dp[i][j] = Math.max(dp[i][j], dp[k][j] + dp[i - k][j]);
                }
                for (int k = 1; k <= j / 2; k++) {
                    dp[i][j] = Math.max(dp[i][j], dp[i][k] + dp[i][j - k]);
                }
            }
        }
        return dp[m][n];
    }

    public static void main(String[] args) {
        Daily20240315Lc2312Solution solution = new Daily20240315Lc2312Solution();
        int m = 3, n = 5;
        int[][] prices = new int[][]{{1,4,2},{2,2,7},{2,1,3}};
        System.out.println(solution.sellingWood(m, n, prices));
    }
}
