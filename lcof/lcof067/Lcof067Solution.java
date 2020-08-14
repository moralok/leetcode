package lcof.lcof067;

public class Lcof067Solution {
    public int strToInt(String str) {
        // 犯错：没处理边界
        if (str.length() == 0) {
            return 0;
        }
        int res = 0, sign = 1, boundry = Integer.MAX_VALUE / 10;
        int i = 0;
        while (str.charAt(i) == ' ') {
            // 犯错：越界了
            i++;
            if (i == str.length()) {
                return 0;
            }
        }
        if (str.charAt(i) == '-') {
            sign = -1;
        }
        if (str.charAt(i) == '-' || str.charAt(i) == '+') {
            i++;
        }
        for (int j = i; j < str.length(); j++) {
            if (str.charAt(j) < '0' || str.charAt(j) > '9' ) {
                break;
            }
            if (res > boundry || res == boundry && str.charAt(j) > '7') {
                return sign == 1 ? Integer.MAX_VALUE : Integer.MIN_VALUE;
            }
            res = res * 10 + (str.charAt(j) - '0');
        }
        return res * sign;
    }
}