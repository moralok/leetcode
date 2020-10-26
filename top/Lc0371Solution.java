package top;

public class Lc0371Solution {
    public int getSum(int a, int b) {
        // 感觉位运算是薄弱点。。。
        return b == 0 ? a : getSum(a ^ b, (a & b) << 1);
    }
}
