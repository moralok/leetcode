package lcof.lcof014_ii;

public class Lcof014IiSolution {
    public int cuttingRope(int n) {
        // 数学推导
        // 大数越界情况下求余问题——循环求余
        // O(log(n)) O(1)
        if (n <= 3) {
            return n - 1;
        }
        int a = n / 3, b = n % 3;
        long res = 1;
        for (int i = 0; i < a - 1; i++) {
            res = (res * 3) % 1000000007;
        }
        if (b == 0) {
            return (int)((res * 3) % 1000000007);
        }
        if (b == 1) {
            return (int)((res * 4) % 1000000007);
        }
        return (int)((res * 3) * 2 % 1000000007);
    }
}