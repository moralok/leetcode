package lcof.lcof043;

public class Lcof043Solution {
    public int countDigitOne(int n) {
        int high = n / 10, low = 0, cur = n % 10, res = 0, digit = 1;
        // 终止条件！！！
        // 抄作业都能错，这公式自己又总结不出来
        while (cur != 0 || high != 0) {
            if (cur == 0) {
                res += high * digit;
            } else if (cur == 1) {
                res += (high * digit+ low + 1);
            } else {
                res += (high + 1) * digit;
            }
            cur = high % 10;
            high /= 10;
            digit *= 10;
            low = n % digit;
        }
        return res;
    }
}