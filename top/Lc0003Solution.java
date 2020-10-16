package top;

import java.util.HashMap;
import java.util.Map;

public class Lc0003Solution {
    public int lengthOfLongestSubstring(String s) {
        // 哈希记录上一次出现的index
        // 错的怀疑人生，感觉老想延迟赋值给答案的想法造成了很大困扰
        if (s == null || s.length() == 0) {
            return 0;
        }
        int max = 0, len = 0;
        Map<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            if (!map.containsKey(ch) || (i - map.get(ch) > len)) {
                // 犯错3：如果未出现过，或者上次出现在当前子串之前
                len++;
            } else if (i - map.get(ch) <= len) {
                // 犯错2:有时候重复出现也无需更新len
                // 更新max
                max = Math.max(max, len);
                len = i - map.get(ch);
            }
            // 记录或更新索引
            map.put(ch, i);
        }
        // 犯错1:有可能s本身就符合要求，尚未更新max
        max = Math.max(max, len);
        return max;
    }

    public static void main(String[] args) {
        Lc0003Solution solution = new Lc0003Solution();
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
