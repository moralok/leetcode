package lcof.lcof015;

public class Lcof015Solution {
    // you need to treat n as an unsigned value
    public int hammingWeight(int n) {
        int res = 0;
        while (n != 0) {
            res += (n & 1);
            // 无符号右移
            n >>>= 1;
        }
        return res;
    }
}