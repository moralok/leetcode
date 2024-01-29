package daily;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Daily20240129Lc0514Solution {

    public int findRotateSteps(String ring, String key) {
        int n = ring.length(), m = key.length();

        // 初始化位置信息
        List<Integer>[] pos = new List[26];
        for (int i = 0; i < 26; i++) {
            pos[i] = new ArrayList<>();
        }
        for (int i = 0; i < ring.length(); i++) {
            char c = ring.charAt(i);
            pos[c - 'a'].add(i);
        }

        // 初始化 dp
        int[][] dp = new int[m][n];
        for (int[] ints : dp) {
            Arrays.fill(ints, Integer.MAX_VALUE);
        }

        // 第一个字符
        for (Integer idx : pos[key.charAt(0) - 'a']) {
            dp[0][idx] = Math.min(idx, n - idx) + 1;
        }

        for (int i = 1; i < m; i++) {
            for (Integer j : pos[key.charAt(i) - 'a']) {
                for (Integer k : pos[key.charAt(i - 1) - 'a']) {
                    dp[i][j] = Math.min(dp[i][j], dp[i - 1][k] + Math.min(Math.abs(j - k), n - Math.abs(j - k)) + 1);
                }
            }
        }

        // 取结果
        int res = Integer.MAX_VALUE;
        for (int s : dp[m - 1]) {
            res = Math.min(res, s);
        }
        return res;
    }

    public static void main(String[] args) {
        Daily20240129Lc0514Solution solution = new Daily20240129Lc0514Solution();
        String ring = "godding";
        String key = "gd";

        assert solution.findRotateSteps(ring, key) == 4;
    }
}
