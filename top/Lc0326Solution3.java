package top;

public class Lc0326Solution3 {
    public boolean isPowerOfThree(int n) {
        // 牛逼！！！取值范围已定
        return n > 0 && 1162261467 % n == 0;
    }
}
