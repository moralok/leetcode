package top;

import java.util.HashMap;
import java.util.Map;

public class Lc0003Solution2 {
    public int lengthOfLongestSubstring(String s) {
        // 哈希记录上一次出现的index，思想一样，但实现更清晰
        if (s == null || s.length() == 0) {
            return 0;
        }
        int res = 0, left = 0;
        Map<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            if (map.containsKey(s.charAt(i))) {
                // 更新左边界
                left = Math.max(left, map.get(s.charAt(i)) + 1);
            }
            map.put(s.charAt(i), i);
            res = Math.max(res, i - left + 1);
        }
        return res;
    }

    public static void main(String[] args) {
        Lc0003Solution2 solution = new Lc0003Solution2();
        String s = "abcabcbb";
        System.out.println(solution.lengthOfLongestSubstring(s));
        s = "bbbbb";
        System.out.println(solution.lengthOfLongestSubstring(s));
        s = "pwwkew";
        System.out.println(solution.lengthOfLongestSubstring(s));
        s = " ";
        System.out.println(solution.lengthOfLongestSubstring(s));
        s = "abba";
        System.out.println(solution.lengthOfLongestSubstring(s));
        s = "tmmzuxt";
        System.out.println(solution.lengthOfLongestSubstring(s));
    }
}
