package lcof.lcof013;

public class Lcof013Solution {

    private int res = 0;
    private boolean[][] visited;

    public int movingCount(int m, int n, int k) {
        // 广度优先遍历
        visited = new boolean[m][n];
        movingCount(m, n, k, 0, 0);
        return res;
    }

    private void movingCount(int m, int n, int k, int i, int j) {
        if (i < 0 || i >= m || j < 0 || j >= n || visited[i][j]) {
            return;
        }
        visited[i][j] = true;
        if (checkCount(i, j, k)) {
            res++;
        } else {
            // 无法经过时要立即返回，因为后续也不能从该处出发
            return;
        }
        // 除非画图感受过，刚开始不确定，往某个方向如果到达不了，迂回也是抵达不了的，呈现三角形辐射
        movingCount(m, n, k, i + 1, j);
        movingCount(m, n, k, i, j + 1);
    }

    // 数位和其实有 +1 或者 -8 的规律
    private boolean checkCount(int i, int j, int k) {
        int count = 0;
        while (i != 0) {
            count += (i % 10);
            i /= 10;
        }
        while (j != 0) {
            count += (j % 10);
            j /= 10;
        }
        return count <= k;
    }
}