package hash_table.count_primes;

public class CountPrimes {
    
    public int countPrimes(int n) {
        int res = 0;
        for (int i = 1; i < n; i++) {
            if (isPrime(i)) {
                res++;
            }
        }
        return res;
    }    

    private boolean isPrime(int n) {
        if (n == 1) {
            return false;
        }
        if (n == 2) {
            return true;
        }
        for (int i = 2; i * i <= n; i++) {
            if (n % i == 0) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        CountPrimes countPrimes = new CountPrimes();
        System.out.println(countPrimes.countPrimes(10));
    }
}