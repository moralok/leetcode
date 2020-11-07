package top;

public class Lc0008Solution {
    public int myAtoi(String s) {
        // 犯了好多细节错
        if (s == null){
            return 0;
        }
        s = s.trim();
        if (s.length() == 0) {
            return 0;
        }
        if (!Character.isDigit(s.charAt(0)) && s.charAt(0) != '-' && s.charAt(0) != '+') {
            return 0;
        }
        boolean neg = s.charAt(0) == '-';
        int i = Character.isDigit(s.charAt(0)) ? 0 : 1;
        int ans = 0;
        while (i < s.length() && Character.isDigit(s.charAt(i))) {
            int tmp = ((neg ? Integer.MIN_VALUE : Integer.MIN_VALUE + 1) + (s.charAt(i) - '0')) / 10;
            if (tmp > ans) {
                return neg ? Integer.MIN_VALUE : Integer.MAX_VALUE;
            }
            ans = ans * 10 - (s.charAt(i++) - '0');
        }
        return neg ? ans : -ans;
    }
}
