package sliding_window;

public class Lc0076Solution {
    public String minWindow(String s, String t) {
        // 一个map保存需要匹配的字符和个数
        // 一个map保存已有的字符和个数
        // 一个统计值保存已经成功匹配的个数并维护
        // 并没有理解到个数也要满足，会以为只需要字符出现呀
        String ret = "";
        Integer min = Integer.MAX_VALUE;
        int[] need = new int[128];
        int[] window = new int[128];
        for (char c : t.toCharArray()) {
            need[c]++;
        }
        int left = 0, right = 0, count = 0;
        while (right < s.length()) {
            char c = s.charAt(right);
            window[c]++;
            if (window[c] <= need[c]) {
                count++;
            }
            while (count == t.length()) {
                if (right - left + 1 < min) {
                    min = right - left + 1;
                    ret = s.substring(left, right + 1);
                }
                char d = s.charAt(left);
                left++;
                window[d]--;
                if (window[d] < need[d]) {
                    count--;
                }
            }
            right++;
        }
        return ret;
    }
}
