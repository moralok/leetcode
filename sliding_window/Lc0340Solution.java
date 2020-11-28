package sliding_window;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public class Lc0340Solution {
    public int lengthOfLongestSubstringKDistinct(String s, int k) {
        int n = s.length();
        if (n < k + 1) {
            return n;
        }
        Map<Character, Integer> map = new HashMap<>();
        int ret = k;
        int left = 0, right = 0;
        while (right < n) {
            map.put(s.charAt(right), right++);
            if (map.size() == k+1) {
                int min = Collections.min(map.values());
                map.remove(s.charAt(min));
                left = min + 1;
            }
            ret = Math.max(ret, right - left);
        }
        return ret;
    }
}
