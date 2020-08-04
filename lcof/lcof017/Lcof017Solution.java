package lcof.lcof017;

public class Lcof017Solution {
    public int[] printNumbers(int n) {
        // 不考虑越界问题
        // 但是据说面试会考大数
        int max = 0;
        while (n-- > 0) {
            max = max * 10 + 9;
        }
        int[] res = new int[max];
        for (int i = 0; i < res.length; i++) {
            res[i] = i + 1;
        }
        return res;
    }
}