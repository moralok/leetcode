package daily;

import common.Utils;

import java.util.Arrays;

public class Lc2171Solution {

    public long minimumRemoval(int[] beans) {
        Arrays.sort(beans);
        int n = beans.length;
        long sum = 0;
        for (int bean : beans) {
            sum += bean;
        }
        long ans = Long.MAX_VALUE;
        for (int i = 0; i < n; i++) {
            long tmp = sum - (long) (n - i) * beans[i];
            ans = Math.min(ans, tmp);
        }
        return ans;
    }

    public static void main(String[] args) {
        Lc2171Solution solution = new Lc2171Solution();
        int[] beans;

        beans = Utils.buildInts("[4,1,6,5]");
        assert solution.minimumRemoval(beans) == 4;

        beans = Utils.buildInts("[2,10,3,2]");
        assert solution.minimumRemoval(beans) == 7;
    }
}
