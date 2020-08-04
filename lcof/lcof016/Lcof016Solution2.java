package lcof.lcof016;

public class Lcof016Solution2 {
    public double myPow(double x, int n) {
        if (x == 0) {
            return 0;
        }
        double res = 1;
        double base = x;
        // 防止−2147483648溢出
        long exp = n;
        // 提前对负值处理
        if (exp < 0) {
            base = 1 / x;
            exp = (-exp);
        }
        while (exp != 0) {
            // 位运算提升效率
            if ((exp & 1) == 1) {
                res *= base;
            }
            base = base * base;
            exp = exp >> 1;
        }
        return res;
    }
}