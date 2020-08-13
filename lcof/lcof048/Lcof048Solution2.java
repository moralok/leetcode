package lcof.lcof048;

import java.util.HashMap;
import java.util.Map;

public class Lcof048Solution2 {
    public int lengthOfLongestSubstring(String s) {
        // 动态规划 + 哈希表
        // 人家的分析思路好清晰啊
        Map<Character, Integer> map = new HashMap<>();
        int res = 0, tmp = 0;
        for (int i = 0; i < s.length(); i++) {
            int j = map.getOrDefault(s.charAt(i), -1);
            map.put(s.charAt(i), i);
            // 确定左边界在哪里
            tmp = (i - j) > tmp ? tmp + 1 : i - j;
            res = Math.max(tmp, res);
        }
        return res;
    }
}