package lcof.lcof048;

import java.util.HashMap;
import java.util.Map;

public class Lcof048Solution {
    public int lengthOfLongestSubstring(String s) {
        // 双指针+哈希表
        char[] chars = s.toCharArray();
        Map<Character, Integer> map = new HashMap<>();
        int begin = 0, end = 0, res = 0;
        for (; end < chars.length; end++) {
            // 注意例子 abba，第一个a不能算为出现了
            // 诶 感觉这类题目每次都更新结果的写法好像更简洁易懂
            if (map.containsKey(chars[end]) && map.get(chars[end]) >= begin) {
                res = Math.max(res, end - begin);
                begin = map.get(chars[end]) + 1;
                map.put(chars[end], end);
            }
            map.put(chars[end], end);
        }
        return Math.max(res, end - begin);
    }
}