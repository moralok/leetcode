package binary_search.is_subsequence;

public class IsSubsequence2 {
    public boolean isSubsequence(String s, String t) {
        // 当需要重复检测数亿个s时的优化
        // 666
        t = " " + t;
        int n = t.length();
        int[][] dp = new int[n][26];
        for (int i = 0; i < 26; i++) {
            int p = -1;
            for (int j = n - 1; j >= 0; j--) {
                dp[j][i] = p;
                if (t.charAt(j) == (i + 'a')) {
                    // 抄作业都能抄错！！！
                    p = j;
                }
            }
        }
        int i = 0;
        for (char ch : s.toCharArray()) {
            i = dp[i][ch - 'a'];
            if (i == -1) {
                return false;
            }
        }
        return true;
    }
}