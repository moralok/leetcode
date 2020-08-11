package lcof.lcof060;

public class Lcof060Solution {
    public double[] twoSum(int n) {
        // 我。。。这是简单的题吗
        // 大佬牛逼
        double[] pre = {1/6d, 1/6d, 1/6d, 1/6d, 1/6d, 1/6d};
        for (int i = 2; i <= n; i++) {
            double[] tmp = new double[6 * i - i + 1];
            for (int j = 0; j < pre.length; j++) {
                for (int k = 0; k < 6; k++) {
                    tmp[j + k] += pre[j] / 6;
                }
            }
            pre = tmp;
        }
        return pre;
    }
}