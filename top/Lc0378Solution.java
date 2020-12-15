package top;

import java.util.PriorityQueue;

public class Lc0378Solution {
    public int kthSmallest(int[][] matrix, int k) {
        PriorityQueue<int[]> queue = new PriorityQueue<>((a, b) -> {
            return a[0] - b[0];
        });
        int n = matrix.length;
        for (int i = 0; i < n; i++) {
            queue.offer(new int[] {matrix[i][0], i, 0});
        }
        for (int i = 0; i < k-1; i++) {
            int[] now = queue.poll();
            if (now[2] != n-1) {
                queue.offer(new int[] {matrix[now[1]][now[2] + 1], now[1], now[2] + 1});
            }
        }
        return queue.poll()[0];
    }
}
