package daily;

import java.util.Arrays;
import java.util.Comparator;

public class Daily20240327Lc2580Solution {

    private static final int MOD = 1000000007;

    public int countWays(int[][] ranges) {
        Arrays.sort(ranges, Comparator.comparingInt(a -> a[0]));
        int last = -1;
        int res = 1;
        for (int[] item : ranges) {
            if (item[0] <= last) {
                last = Math.max(last, item[1]);
            } else {
                last = item[1];
                res = (res * 2) % MOD;
            }
        }
        return res;
    }

    public static void main(String[] args) {
        Daily20240327Lc2580Solution solution = new Daily20240327Lc2580Solution();
        int[][] ranges = new int[][]{{6, 10}, {5,15}};
        assert solution.countWays(ranges) == 2;
        ranges = new int[][]{{1, 3}, {10, 20}, {2, 5}, {4, 8}};
        assert solution.countWays(ranges) == 4;
    }
}
