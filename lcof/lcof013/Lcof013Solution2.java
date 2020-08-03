package lcof.lcof013;

public class Lcof013Solution2 {

    private boolean[][] visited;

    public int movingCount(int m, int n, int k) {
        // 深度优先遍历
        visited = new boolean[m][n];
        return movingCount(m, n, k, 0, 0, 0, 0);
    }

    private int movingCount(int m, int n, int k, int i, int j, int si, int sj) {
        if (i < 0 || i >= m || j < 0 || j >= n || visited[i][j] || (si + sj) > k) {
            return 0;
        }
        visited[i][j] = true;
        // 用数位和规律效率更高
        return 1 + movingCount(m, n, k, i + 1, j, (i+1) % 10 != 0 ? si + 1 : si - 8, sj) + movingCount(m, n, k, i, j + 1, si, (j+1) % 10 != 0 ? sj + 1 : sj - 8);
    }
}