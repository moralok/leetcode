package lcof.lcof062;

public class Lcof062Solution {
    public int lastRemaining(int n, int m) {
        // 递归，又懵逼了
        return f(n, m);
    }

    private int f(int n, int m) {
        if (n == 1) {
            // 基准情形
            return 0;
        }
        int x = f(n - 1, m);
        return (m + x) % n;
    }
}