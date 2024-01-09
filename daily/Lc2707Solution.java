package daily;

import java.util.*;

public class Lc2707Solution {

    public int minExtraChar(String s, String[] dictionary) {
        int n = s.length();
        int[] dp = new int[n + 1];
        Arrays.fill(dp, Integer.MAX_VALUE);
        dp[0] = 0;
        Set<String> set = new HashSet<>();
        Collections.addAll(set, dictionary);

        for (int i = 1; i <= n; i++) {
            dp[i] = dp[i - 1] + 1;
            for (int j = i - 1; j >= 0; j--) {
                if (set.contains(s.substring(j, i))) {
                    dp[i] = Math.min(dp[i], dp[j]);
                }
            }
        }

        return dp[n];
    }

    public static void main(String[] args) {
        Lc2707Solution solution = new Lc2707Solution();
        String s;
        String[] dictionary;

        s = "leetscode";
        dictionary = new String[] {"leet","code","leetcode"};
        assert solution.minExtraChar(s, dictionary) == 1;

        s = "sayhelloworld";
        dictionary = new String[] {"hello","world"};
        assert solution.minExtraChar(s, dictionary) == 3;
    }
}
