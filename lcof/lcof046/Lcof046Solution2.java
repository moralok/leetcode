package lcof.lcof046;

public class Lcof046Solution2 {
    public int translateNum(int num) {
        int prePre = 1, pre = 1;
        int curDigit, preDigit = num % 10;
        // 感觉用 num/10 判断好理解，要不然总感觉没有对应到对应的数字
        while (num/10 != 0) {
            num /= 10;
            curDigit = num % 10;
            int tmp = 10 * curDigit + preDigit;
            int cur = (tmp >= 10 && tmp <= 25) ? prePre + pre : pre;
            prePre = pre;
            pre = cur;
            preDigit = curDigit;
        }
        return pre;
    }
}