package lcof.lcof048;

import java.util.HashMap;
import java.util.Map;

public class Lcof048Solution3 {
    public int lengthOfLongestSubstring(String s) {
        // 双指针+哈希表，仿照简洁的写法，本质上同解法1
        Map<Character, Integer> map = new HashMap<>();
        int begin = 0, end = 0, res = 0;
        for (; end < s.length(); end++) {
            if (map.containsKey(s.charAt(end))) {
                begin = Math.max(begin, map.get(s.charAt(end)) + 1);
            }
            map.put(s.charAt(end), end);
            res = Math.max(res, end - begin + 1);
        }
        return res;
    }
}