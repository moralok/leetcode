package lcof.lcof014_i;

public class Lcof014ISolution {
    public int cuttingRope(int n) {
        // 数学推导
        // O(1) O(1)
        if (n <= 3) {
            return n - 1;
        }
        int a = n / 3, b = n % 3;
        if (b == 0) {
            return (int)Math.pow(3, a);
        }
        if (b == 1) {
            return (int)Math.pow(3, a - 1) * 4;
        }
        return (int)Math.pow(3, a) * 2;
    }
}