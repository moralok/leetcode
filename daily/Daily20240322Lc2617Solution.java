package daily;

import java.util.Arrays;
import java.util.PriorityQueue;

public class Daily20240322Lc2617Solution {

    public int minimumVisitedCells(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        int[][] dp = new int[m][n];
        for (int i = 0; i < m; i++) {
            Arrays.fill(dp[i], -1);
        }
        dp[0][0] = 1;
        PriorityQueue<int[]>[] rows = new PriorityQueue[m];
        PriorityQueue<int[]>[] cols = new PriorityQueue[n];
        for (int i = 0; i < m; i++) {
            rows[i] = new PriorityQueue<>((a, b) -> a[0] - b[0]);
        }
        for (int i = 0; i < n; i++) {
            cols[i] = new PriorityQueue<>((a, b) -> a[0] - b[0]);
        }
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                while (!rows[i].isEmpty() && rows[i].peek()[1] + grid[i][rows[i].peek()[1]] < j) {
                    rows[i].poll();
                }
                if (!rows[i].isEmpty()) {
                    dp[i][j] = update(dp[i][j], dp[i][rows[i].peek()[1]] + 1);
                }
                while (!cols[j].isEmpty() && cols[j].peek()[1] + grid[cols[j].peek()[1]][j] < i ) {
                    cols[j].poll();
                }
                if (!cols[j].isEmpty()) {
                    dp[i][j] = update(dp[i][j], dp[cols[j].peek()[1]][j] + 1);
                }
                if (dp[i][j] != -1) {
                    rows[i].offer(new int[]{dp[i][j], j});
                    cols[j].offer(new int[]{dp[i][j], i});
                }
            }
        }
        return dp[m - 1][n - 1];
    }

    public int update(int x, int y) {
        return x == -1 || y < x ? y : x;
    }

    // 超时
    public int minimumVisitedCells1(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        int[][] dp = new int[m][n];
        for (int i = 0; i < m; i++) {
            Arrays.fill(dp[i], -1);
        }
        dp[0][0] = 1;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                PriorityQueue<int[]> queue1 = new PriorityQueue<>((a, b) -> a[0] - b[0]);
                PriorityQueue<int[]> queue2 = new PriorityQueue<>((a, b) -> a[0] - b[0]);
                for (int k = 0; k < i; k++) {
                    if (dp[k][j] != -1) {
                        queue1.offer(new int[]{dp[k][j], k, j});
                    }
                }
                for (int k = 0; k < j; k++) {
                    if (dp[i][k] != -1) {
                        queue2.offer(new int[]{dp[i][k], i, k});
                    }
                }
                while (!queue1.isEmpty() || !queue2.isEmpty()) {
                    int[] cur;
                    if (queue1.isEmpty() || (!queue2.isEmpty() && queue2.peek()[0] < queue1.peek()[0])) {
                        cur = queue2.poll();
                        if (grid[cur[1]][cur[2]] + cur[2] >= j) {
                            dp[i][j] = dp[cur[1]][cur[2]] + 1;
                            break;
                        }
                    } else {
                        cur = queue1.poll();
                        if (grid[cur[1]][cur[2]] + cur[1] >= i) {
                            dp[i][j] = dp[cur[1]][cur[2]] + 1;
                            break;
                        }
                    }
                }
            }
        }
        return dp[m - 1][n - 1];
    }

    public static void main(String[] args) {
        Daily20240322Lc2617Solution solution = new Daily20240322Lc2617Solution();
        int[][] grid = {
                {3, 4, 2, 1},
                {4, 2, 3, 1},
                {2, 1, 0, 0},
                {2, 4, 0, 0}
        };
        assert solution.minimumVisitedCells(grid) == 4;
        grid = new int[][]{
                {3, 4, 2, 1},
                {4, 2, 1, 1},
                {2, 1, 1, 0},
                {3, 4, 1, 0}
        };
        assert solution.minimumVisitedCells(grid) == 3;
    }
}
