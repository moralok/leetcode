package dynamic_programming;

public class Lc1143Solution {
    public int longestCommonSubsequence(String text1, String text2) {
        // dp[i][j] =
        // 1. dp[i-1][j-1] + 1  (text1[i] == text2[j])
        // 2. max(dp[i][j-1], dp[i-1][j])  (text1[i] != text2[j])
        // 两者取较大值
        int n = text1.length();
        int m = text2.length();
        int[][] dp = new int[n + 1][m + 1];
        for (int i = 0; i <= n; i++) {
            dp[i][0] = 0;
        }
        for (int i = 0; i <= m; i++) {
            dp[0][i] = 0;
        }
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= m; j++) {
                if (text1.charAt(i-1) == text2.charAt(j-1)) {
                    dp[i][j] = dp[i-1][j-1] + 1;
                } else {
                    dp[i][j] = Math.max(dp[i-1][j], dp[i][j-1]);
                }
            }
        }
        return dp[n][m];
    }

    public static void main(String[] args) {
        Lc1143Solution solution = new Lc1143Solution();
        String text1 = "abc";
        String text2 = "aec";
        System.out.println(solution.longestCommonSubsequence(text1, text2));
        text1 = "abc";
        text2 = "def";
        System.out.println(solution.longestCommonSubsequence(text1, text2));
    }
}
