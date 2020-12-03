package daily;

public class Lc0204Solution {
    public int countPrimes(int n) {
        int ret = 0;
        for (int i = 2; i < n; i++) {
            ret += isPrime(i) ? 1 : 0;
        }
        return ret;
    }

    private boolean isPrime(int x) {
        for (int i = 2; i * i <= x; i++) {
            if (x % i == 0) {
                return false;
            }
        }
        return true;
    }
}
