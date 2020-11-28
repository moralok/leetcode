package sliding_window;

import java.util.HashMap;
import java.util.Map;

public class Lc0003Solution {
    public int lengthOfLongestSubstring(String s) {
        if (s == null || s.length() == 0) {
            return 0;
        }
        int start = 0, ret = 0;
        Map<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (map.containsKey(c)) {
                start = Math.max(start, map.get(c) + 1);
            }
            ret = Math.max(ret, i - start + 1);
            map.put(c, i);
        }
        return ret;
    }

    public static void main(String[] args) {
        Lc0003Solution solution = new Lc0003Solution();
        String s = "abcabc";
        System.out.println(solution.lengthOfLongestSubstring(s));
        s = "";
        System.out.println(solution.lengthOfLongestSubstring(s));
        s = "aaaa";
        System.out.println(solution.lengthOfLongestSubstring(s));
        s = "pwwkew";
        System.out.println(solution.lengthOfLongestSubstring(s));
    }
}
