package top;

public class Lc0171Solution {
    public int titleToNumber(String s) {
        // 作为26进制理解
        if (s == null || s.length() == 0) {
            return 0;
        }
        int ret = 0;
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            ret = ret * 26 + (ch - 'A' + 1);
        }
        return ret;
    }
}
