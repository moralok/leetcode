package daily;

import common.Utils;

import java.util.HashMap;
import java.util.Map;

public class Lc2085Solution {

    public int countWords(String[] words1, String[] words2) {
        Map<String, Integer> counts1 = new HashMap<>();
        Map<String, Integer> counts2 = new HashMap<>();
        for (String word : words1) {
            counts1.put(word, counts1.getOrDefault(word, 0) + 1);
        }
        for (String word : words2) {
            counts2.put(word, counts2.getOrDefault(word, 0) + 1);
        }
        int ret = 0;
        for (Map.Entry<String, Integer> entry : counts2.entrySet()) {
            if (entry.getValue() == 1 && counts1.getOrDefault(entry.getKey(), 0) == 1) {
                ret++;
            }
        }
        return ret;
    }

    public static void main(String[] args) {
        Lc2085Solution solution = new Lc2085Solution();
        String[] word1;
        String[] word2;

        word1 = Utils.buildStrings("[\"leetcode\",\"is\",\"amazing\",\"as\",\"is\"]");
        word2 = Utils.buildStrings("[\"amazing\",\"leetcode\",\"is\"]");
        assert solution.countWords(word1, word2) == 2;

        word1 = Utils.buildStrings("[\"b\",\"bb\",\"bbb\"]");
        word2 = Utils.buildStrings("[\"a\",\"aa\",\"aaa\"]");
        assert solution.countWords(word1, word2) == 0;

        word1 = Utils.buildStrings("[\"a\",\"ab\"]");
        word2 = Utils.buildStrings("[\"a\",\"a\",\"a\",\"ab\"]");
        assert solution.countWords(word1, word2) == 1;
    }
}
