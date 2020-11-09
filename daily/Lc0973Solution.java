package daily;

import java.util.PriorityQueue;

public class Lc0973Solution {
    public int[][] kClosest(int[][] points, int K) {
        PriorityQueue<int[]> queue = new PriorityQueue<>((x, y) -> y[0] - x[0]);
        for (int i = 0; i < K; i++) {
            queue.offer(new int[]{points[i][0]*points[i][0]+points[i][1]*points[i][1], i});
        }
        for (int i = K; i < points.length; i++) {
            int dist = points[i][0]*points[i][0]+points[i][1]*points[i][1];
            if (dist < queue.peek()[0]) {
                queue.poll();
                queue.offer(new int[]{dist, i});
            }
        }
        int[][] ans = new int[K][2];
        for (int i = 0; i < K; ++i) {
            ans[i] = points[queue.poll()[1]];
        }
        return ans;
    }
}
