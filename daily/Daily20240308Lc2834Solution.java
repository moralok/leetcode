package daily;

public class Daily20240308Lc2834Solution {

    public int minimumPossibleSum(int n, int target) {
        final int MOD = (int) 1e9 + 7;
        int half = target / 2;
        if (n <= half) {
            return (1 + n) * n / 2;
        }
        long sum = ((long) (1 + half) * half / 2) % MOD;
        int left = n - half;
        sum = sum + (((long) target + target + left - 1) * left / 2) % MOD;
        return (int) (sum % MOD);
    }

    public int minimumPossibleSum1(int n, int target) {
        final int MOD = (int) 1e9 + 7;
        int n1 = Math.min(target / 2, n);
        long sum = 0;
        for (int i = 1; i <= n1; i++) {
            sum = (sum + i) % MOD;
        }
        int n2 = n - n1;
        for (int i = 0; i < n2; i++) {
            sum = (sum + target + i) % MOD;
        }
        return (int) sum;
    }

    public static void main(String[] args) {
        Daily20240308Lc2834Solution solution = new Daily20240308Lc2834Solution();
        int n = 1, target = 1;
        assert solution.minimumPossibleSum(n, target) == 1;
        n = 2; target = 3;
        assert solution.minimumPossibleSum(n, target) == 4;
        n = 13; target = 50;
        assert solution.minimumPossibleSum(n, target) == 91;
        n = 45456; target = 10867;
        assert solution.minimumPossibleSum(n, target) == 250591648;
        n = 1000000000; target = 1000000000;
        assert solution.minimumPossibleSum(n, target) == 750000042;
    }
}
