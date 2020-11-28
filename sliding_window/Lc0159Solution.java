package sliding_window;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public class Lc0159Solution {
    public int lengthOfLongestSubstringTwoDistinct(String s) {
        int n = s.length();
        if (n < 3) {
            return n;
        }
        Map<Character, Integer> map = new HashMap<>();
        int ret = 2;
        int left = 0, right = 0;
        while (right < n) {
            map.put(s.charAt(right), right++);
            if (map.size() == 3) {
                int min = Collections.min(map.values());
                map.remove(s.charAt(min));
                left = min + 1;
            }
            ret = Math.max(ret, right - left);
        }
        return ret;
    }

    public static void main(String[] args) {
        Lc0159Solution solution = new Lc0159Solution();
        String s = "eceba";
        System.out.println(solution.lengthOfLongestSubstringTwoDistinct(s));
    }
}
