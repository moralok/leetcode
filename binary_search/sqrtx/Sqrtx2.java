package binary_search.sqrtx;

public class Sqrtx2 {
    public int mySqrt(int x) {
        // 牛顿-拉弗逊法
        if (x == 0) {
            return 0;
        }
        double C = x, x0 = x;
        while (true) {
            double xi = 0.5 * (x0 + C / x0);
            if (Math.abs(xi - x0) < 1e-7) {
                break;
            }
            x0 = xi;
        }
        return (int)x0;
    }
}