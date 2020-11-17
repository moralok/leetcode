package daily;

import java.util.ArrayList;
import java.util.List;

public class Lc1030Solution2 {
    public int[][] allCellsDistOrder(int R, int C, int r0, int c0) {
        int maxDist = Math.max(r0, R - 1 - r0) + Math.max(c0, C - 1 -c0);
        List<List<int[]>> bucket = new ArrayList<>();
        for (int i = 0; i <= maxDist; i++) {
            bucket.add(new ArrayList<>());
        }
        for (int i = 0; i < R; i++) {
            for (int j = 0; j < C; j++) {
                int d = dist(i, j, r0, c0);
                bucket.get(d).add(new int[] {i, j});
            }
        }

        int idx = 0;
        int[][] ret = new int[R * C][];
        for (int i = 0; i <= maxDist; i++) {
            for (int[] it : bucket.get(i)) {
                ret[idx++] = it;
            }
        }
        return ret;
    }

    private int dist(int i, int j, int r0, int c0) {
        return Math.abs(i - r0) + Math.abs(j - c0);
    }
}
