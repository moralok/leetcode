package daily;

public class Lc0463Solution {

    public int islandPerimeter(int[][] grid) {
        // 即使是笨笨的思路也已开始没想那么明白，更不用说深度优先遍历了
        int n = grid.length;
        int m = grid[0].length;
        int[] dx = new int[] {1, -1, 0, 0};
        int[] dy = new int[] {0, 0, 1, -1};
        int ret = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (grid[i][j] == 1) {
                    for (int k = 0; k < 4; k++) {
                        int x = i + dx[k];
                        int y = j + dy[k];
                        if (x < 0 || x >= n || y < 0 || y >= m || grid[x][y] == 0) {
                            ret++;
                        }
                    }
                }
            }
        }
        return ret;
    }
}