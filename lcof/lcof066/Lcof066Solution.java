package lcof.lcof066;

public class Lcof066Solution {
    public int[] constructArr(int[] a) {
        // 动态规划
        if (a.length == 0) {
            return new int[0];
        }
        int[] res = new int[a.length];
        res[0] = 1;
        for (int i = 1; i < res.length; i++) {
            res[i] = res[i - 1] * a[i - 1];
        }
        int tmp = 1;
        for (int i = res.length - 2; i >= 0; i--) {
            tmp = tmp * a[i + 1];
            res[i] = res[i] * tmp;
        }
        return res;
    }
}