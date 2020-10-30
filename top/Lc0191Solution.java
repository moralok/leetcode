package top;

public class Lc0191Solution {
    
    // you need to treat n as an unsigned value
    public int hammingWeight(int n) {
        // 也可以将mask左移，循环32次
        int ret = 0;
        while (n != 0) {
            ret += (n & 1);
            n >>>= 1;
        }
        return ret;
    }
}
