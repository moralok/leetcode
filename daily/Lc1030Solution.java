package daily;

import java.util.Arrays;

public class Lc1030Solution {
    public int[][] allCellsDistOrder(int R, int C, int r0, int c0) {
        int[][] ret = new int[R * C][];
        for (int i = 0; i < R; i++) {
            for (int j = 0; j < C; j++) {
                ret[C*i+j] = new int[] {i, j};
            }
        }
        Arrays.sort(ret, (a1, a2) -> {
            return (Math.abs(a1[0] - r0) + Math.abs(a1[1] - c0)) - (Math.abs(a2[0] - r0) + Math.abs(a2[1] - c0));
        });
        return ret;
    }
}
