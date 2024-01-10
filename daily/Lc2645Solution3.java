package daily;

public class Lc2645Solution3 {

    // 动态规划真妙
    public int addMinimum(String word) {
        int n = word.length();
        int[] dp = new int[2];
        dp[1] = dp[0] + 2;
        for (int i = 1; i < n; i++) {
            if (word.charAt(i) <= word.charAt(i - 1)) {
                dp[(i + 1) % 2] = dp[i % 2] + 2;
            } else {
                dp[(i + 1) % 2] = dp[i % 2] - 1;
            }
        }
        return dp[n % 2];
    }

    public static void main(String[] args) {
        Lc2645Solution3 solution = new Lc2645Solution3();
        String word;

        word = "b";
        assert solution.addMinimum(word) == 2;

        word = "aaa";
        assert solution.addMinimum(word) == 6;

        word = "abc";
        assert solution.addMinimum(word) == 0;
    }
}
