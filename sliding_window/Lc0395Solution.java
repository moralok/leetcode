package sliding_window;

import java.util.HashMap;
import java.util.Map;

public class Lc0395Solution {
    public int longestSubstring(String s, int k) {
        // 这也算滑动窗口法吗？
        // 感觉思路不难，自己却有思维定式，菜！
        if (s == null || s.length() == 0) {
            return 0;
        }
        Map<Character, Integer> map = new HashMap<>();
        for (char c : s.toCharArray()) {
            map.put(c, map.getOrDefault(c, 0) + 1);
        }
        StringBuilder sb = new StringBuilder(s);
        for (int i = 0; i < s.length(); i++) {
            if (map.get(s.charAt(i)) < k) {
                sb.setCharAt(i, ',');
            }
        }
        String[] strings = sb.toString().split(",");
        if (strings.length == 1) {
            return strings[0].length();
        }
        int max = 0;
        for (String string : strings) {
            max = Math.max(max, longestSubstring(string, k));
        }
        return max;
    }
}
