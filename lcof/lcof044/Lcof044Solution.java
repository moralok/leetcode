package lcof.lcof044;

public class Lcof044Solution {
    public int findNthDigit(int n) {
        // 超时
        int x = 0;
        int len = 0;
        while (n >= 0) {
            len = getLength(x);
            if (n - len < 0) {
                break;
            }
            n = n - len;
            x = x + 1;
        }
        return (int)(x / Math.pow(10, len - n)) % 10;
    }

    private int getLength(int x) {
        int res = 0;
        do {
            x /= 10;
        } while (x != 0);
        return res;
    }
}