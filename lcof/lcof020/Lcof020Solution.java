package lcof.lcof020;

public class Lcof020Solution {
    public boolean isNumber(String s) {
        // 状态机那位大佬太秀了
        boolean numericSeen = false;
        boolean dotSeen = false;
        boolean eSeen = false;
        char[] chars = s.trim().toCharArray();
        for (int i = 0; i < chars.length; i++) {
            if (chars[i] >= '0' && chars[i] <= '9') {
                numericSeen = true;
            } else if (chars[i] == '.') {
                if (dotSeen || eSeen) {
                    return false;
                }
                dotSeen = true;
            } else if (chars[i] == 'e' || chars[i] == 'E') {
                if (eSeen || !numericSeen) {
                    return false;
                }
                eSeen = true;
                numericSeen = false;
            } else if (chars[i] == '-' || chars[i] == '+') {
                if (i != 0 && chars[i - 1] != 'e' && chars[i - 1] != 'E') {
                    return false;
                }
            } else {
                return false;
            }
        }
        return numericSeen;
    }
}