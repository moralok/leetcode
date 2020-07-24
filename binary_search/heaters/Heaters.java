package binary_search.heaters;

import java.util.Arrays;

public class Heaters {
    public int findRadius(int[] houses, int[] heaters) {
        // 开始都理解不了题意
        int res = 0;
        int n = heaters.length;
        // 先排序
        Arrays.sort(houses);
        Arrays.sort(heaters);
        for (int house : houses) {
            int lo = 0, hi = n - 1;
            while (lo < hi) {
                int mid = lo + (hi - lo) / 2;
                if (heaters[mid] < house) {
                    lo = mid + 1;
                } else {
                    hi = mid;
                }
            }
            int dist1 = hi == 0 ? Integer.MAX_VALUE : Math.abs(house - heaters[hi - 1]);
            int dist2 = Math.abs(house - heaters[hi]);
            res = Math.max(res, Math.min(dist1, dist2));
        }
        return res;
    }
}