package hash_table.count_primes;

public class CountPrimes2 {
    
    public int countPrimes(int n) {
        // 默认false代表素数
        boolean[] isPrime = new boolean[n];
        for (int i = 2; i * i < n; i++) {
            if (!isPrime[i]) {
                for (int j = i * i; j < n; j = j + i) {
                    isPrime[j] = true;
                }
            }
        }
        int res = 0;
        for (int i = 2; i < n; i++) {
            if (!isPrime[i]) {
                res++;
            }
        }
        return res;
    }

    public static void main(String[] args) {
        CountPrimes2 countPrimes = new CountPrimes2();
        System.out.println(countPrimes.countPrimes(10));
    }
}