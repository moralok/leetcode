package daily;

import java.util.Arrays;

public class Lc0452Solution {
    public int findMinArrowShots(int[][] points) {
        if (points.length == 0) {
            return 0;
        }
        Arrays.sort(points, (p1, p2) -> p1[1] <= p2[1] ? -1 : 1);
        int pre = points[0][1];
        int ret = 1;
        for (int[] point : points) {
            if (point[0] > pre) {
                ret++;
                pre = point[1];
            }
        }
        return ret;
    }
}
