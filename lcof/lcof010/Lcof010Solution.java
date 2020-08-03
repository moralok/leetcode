package lcof.lcof010;

public class Lcof010Solution {
    public int fib(int n) {
        // 递归 超时
        if (n == 0) {
            return 0;
        }
        if (n == 1) {
            return 1;
        }
        return (fib(n - 1) + fib(n - 2)) % 1000000007;
    }
}