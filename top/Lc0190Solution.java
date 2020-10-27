package top;

public class Lc0190Solution {
    public int reverseBits(int n) {
        // O(log(n))，其实上限是常数
        int ret = 0, pow = 31;
        while (n != 0) {
            ret += (n & 1) << pow;
            // 右移
            n = n >>> 1;
            pow--;
        }
        return ret;
    }
}
