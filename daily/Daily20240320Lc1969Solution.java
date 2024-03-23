package daily;

public class Daily20240320Lc1969Solution {

    public int minNonZeroProduct(int p) {
        long mod = 1000000007;
        long n = (1L << p) - 1;
        long m = n - 1;
        long res = pow(m % mod, n / 2, mod);
        res = res * (n % mod) % mod;
        return (int) res;
    }

    private long pow(long x, long y, long mod) {
        long res = 1;
        while (y > 0) {
            if ((y & 1) != 0) {
                res = res * x % mod;
            }
            x = x * x % mod;
            y >>= 1;
        }
        return res;
    }

    public static void main(String[] args) {
        Daily20240320Lc1969Solution solution = new Daily20240320Lc1969Solution();
        assert solution.minNonZeroProduct(32) == 505517599;
    }
}
