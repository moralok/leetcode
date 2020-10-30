package daily;

public class Lc0463Solution2 {

    private int[] dx = new int[] {1, -1, 0, 0};
    private int[] dy = new int[] {0, 0, 1, -1};

    public int islandPerimeter(int[][] grid) {
        // 深度优先遍历可扩展至统计多岛屿各自周长
        int n = grid.length;
        int m = grid[0].length;
        
        int ret = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (grid[i][j] == 1) {
                    ret += dfs(grid, i, j, n, m);
                }
            }
        }
        return ret;
    }

    private int dfs(int[][] grid, int i, int j, int n, int m) {
        if (i < 0 || i >= n || j < 0 || j >= m || grid[i][j] == 0) {
            return 1;
        }
        if (grid[i][j] == 2) {
            return 0;
        }
        grid[i][j] = 2;
        int ret = 0;
        for (int k = 0; k < 4; k++) {
            int x = i + dx[k];
            int y = j + dy[k];
            ret += dfs(grid, x, y, n, m);
        }
        return ret;
    }
}