package lcof.lcof015;

public class Lcof015Solution2 {
    // you need to treat n as an unsigned value
    public int hammingWeight(int n) {
        // 巧用 n&(n-1) 消去最右边的1
        int res = 0;
        while (n != 0) {
            res++;
            n &= (n - 1);
        }
        return res;
    }
}