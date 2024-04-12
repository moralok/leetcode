package daily;

public class Daily20240412Lc2923Solution {

    public int findChampion(int[][] grid) {
        int n = grid.length;
        int res = 0;
        while (true) {
            int i = 0;
            for (; i < n; i++) {
                if (i != res && grid[res][i] == 0) {
                    res = i;
                    break;
                }
            }
            if (i == n) {
                return res;
            }
        }
    }
}
