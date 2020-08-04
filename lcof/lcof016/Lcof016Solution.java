package lcof.lcof016;

public class Lcof016Solution {
    public double myPow(double x, int n) {
        if (x == 0) {
            return 0;
        }
        double res = 1;
        double base = x;
        int exp = Math.abs(n);
        while (exp != 0) {
            if (exp % 2 == 1) {
                res *= base;
            }
            base = base * base;
            if (Double.isInfinite(base)) {
                return 0;
            }
            exp = exp / 2;
        }
        if (n < 0) {
            res = 1 / res;
        }
        return res;
    }
}