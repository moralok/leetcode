package top;

public class Lc0191Solution2 {
    
    // you need to treat n as an unsigned value
    public int hammingWeight(int n) {
        // n&(n-1) 会反转最后一个1
        int ret = 0;
        while (n != 0) {
            ret++;
            n &= (n - 1);
        }
        return ret;
    }
}
