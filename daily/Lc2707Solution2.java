package daily;

import java.util.Arrays;

public class Lc2707Solution2 {

    public int minExtraChar(String s, String[] dictionary) {
        int n = s.length();
        int[] dp = new int[n + 1];
        Arrays.fill(dp, Integer.MAX_VALUE);
        dp[0] = 0;
        Trie trie = new Trie();
        for (String str : dictionary) {
            StringBuilder sb = new StringBuilder(str).reverse();
            trie.insert(sb.toString());
        }

        for (int i = 1; i <= n; i++) {
            dp[i] = dp[i - 1] + 1;
            Trie tmp = trie;
            for (int j = i - 1; j >= 0; j--) {
                tmp = tmp.track(s.charAt(j));
                // 提前 break，注意别出错
                if (tmp == null) {
                    break;
                }
                if (tmp.isEnd) {
                    dp[i] = Math.min(dp[i], dp[j]);
                }
            }
        }

        return dp[n];
    }

    static class Trie {
        private final Trie[] children;
        private boolean isEnd;

        Trie () {
            children = new Trie[26];
            isEnd = false;
        }

        public void insert(String word) {
            Trie trie = this;
            for (int i = 0; i < word.length(); i++) {
                int idx = word.charAt(i) - 'a';
                if (trie.children[idx] == null) {
                    trie.children[idx] = new Trie();
                }
                trie = trie.children[idx];
            }
            trie.isEnd = true;
        }

        public Trie track(char ch) {
            Trie trie = this;
            return trie.children[ch - 'a'];
        }
    }

    public static void main(String[] args) {
        Lc2707Solution2 solution = new Lc2707Solution2();
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
