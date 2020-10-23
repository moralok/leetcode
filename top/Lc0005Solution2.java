package top;

public class Lc0005Solution2 {
    public String longestPalindrome(String s) {
        // dp 这么慢的吗。。。
        if (s == null || s.length() == 0) {
            return "";
        }
        int n = s.length();
        boolean[][] dp = new boolean[n][n];
        int start = 0, end = 0;
        for (int len = 0; len < n; len++) {
            for (int i = 0; i + len < n; i++) {
                int j = i + len;
                if (len == 0) {
                    dp[i][j] = true;
                } else if (len == 1) {
                    dp[i][j] = s.charAt(i) == s.charAt(j);
                } else {
                    dp[i][j] = dp[i + 1][j - 1] && s.charAt(i) == s.charAt(j);
                }
                if (dp[i][j] && j - i > end - start) {
                    start = i;
                    end = j;
                }
            }
        }
        return s.substring(start, end + 1);
    }

    public static void main(String[] args) {
        Lc0005Solution2 solution = new Lc0005Solution2();
        String s = "babad";
        System.out.println(solution.longestPalindrome(s));
        s = "cbbd";
        System.out.println(solution.longestPalindrome(s));
    }
}
