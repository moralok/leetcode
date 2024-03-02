package daily;

import java.util.ArrayList;
import java.util.List;

public class Daily20240302Lc2368Solution {

    public int reachableNodes(int n, int[][] edges, int[] restricted) {
        List<Integer>[] G = new ArrayList[n];
        for (int i = 0; i < n; i++) {
            G[i] = new ArrayList<>();
        }
        for (int[] edge : edges) {
            int a = edge[0], b = edge[1];
            G[a].add(b);
            G[b].add(a);
        }

        boolean[] restrictedSet = new boolean[n];
        for (int i : restricted) {
            restrictedSet[i] = true;
        }

        int[] res = new int[1];
        res[0] = 1;
        dfs(res, 0, -1, restrictedSet, G);
        return res[0];
    }

    private void dfs(int[] res, int cur, int pre, boolean[] restrictedSet, List<Integer>[] G) {
        for (Integer next : G[cur]) {
            if (next != pre && !restrictedSet[next]) {
                res[0]++;
                dfs(res, next, cur, restrictedSet, G);
            }
        }
    }

    public static void main(String[] args) {
        Daily20240302Lc2368Solution solution = new Daily20240302Lc2368Solution();
        int n = 7;
        int[][] edges = new int[][] {new int[] {0,1},new int[] {1,2},new int[] {3,1},new int[] {4,0},new int[] {0,5},new int[] {5,6}};
        int[] restricted = new int[] {4,5};
        assert solution.reachableNodes(n, edges, restricted) == 4;
    }
}
