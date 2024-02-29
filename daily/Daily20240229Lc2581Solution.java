package daily;

import java.util.*;

public class Daily20240229Lc2581Solution {

    private int res = 0, cnt = 0;
    private int k;
    private List<Integer>[] g;
    private Set<Long> set;


    public int rootCount(int[][] edges, int[][] guesses, int k) {
        this.k = k;
        int n = edges.length + 1;
        g = new ArrayList[n];
        for (int i = 0; i < n; i++) {
            g[i] = new ArrayList<>();
        }
        for (int[] edge : edges) {
            g[edge[0]].add(edge[1]);
            g[edge[1]].add(edge[0]);
        }
        set = new HashSet<>();
        for (int[] guess : guesses) {
            set.add(h(guess[0], guess[1]));
        }

        dfs(0, -1);
        reDfs(0, -1, cnt);
        return res;
    }

    private long h(int x, int y) {
        return (long) x << 20 | y;
    }

    private void dfs(int x, int fat) {
        for (int p : g[x]) {
            if (p == fat) {
                continue;
            }
            if (set.contains(h(x, p))) {
                cnt += 1;
            }
            dfs(p, x);
        }
    }

    private void reDfs(int x, int fat, int curCnt) {
        // System.out.println("" + x + "    " + fat + "    " + curCnt);
        if (curCnt >= k) {
            res++;
        }
        for (int y : g[x]) {
            if (y == fat) {
                continue;
            }
            // 这段愚蠢的代码 debug 得我脑壳都烂了，我真蠢！！！
            int tmp = curCnt;
            if (set.contains(h(x, y))) {
                tmp -= 1;
            }
            if (set.contains(h(y, x))) {
                tmp += 1;
            }
            reDfs(y, x, tmp);

            // reDfs(y, x, curCnt - (set.contains(h(x, y)) ? 1 : 0) + (set.contains(h(y, x)) ? 1 : 0));
        }
    }

    public static void main(String[] args) {
        Daily20240229Lc2581Solution solution = new Daily20240229Lc2581Solution();

        int[][] edges = new int[][] {new int[]{0,1},new int[]{2,0},new int[]{0,3},new int[]{4,2},new int[]{3,5},new int[]{6,0},new int[]{1,7},new int[]{2,8},new int[]{2,9},new int[]{4,10},new int[]{9,11},new int[]{3,12},new int[]{13,8},new int[]{14,9},new int[]{15,9},new int[]{10,16}};
        int[][] guesses = new int[][] {new int[] {8,2}, new int[] {12,3}, new int[] {0,1}, new int [] {16,10}};
        int k = 2;
        System.out.println(solution.rootCount(edges, guesses, k));
    }
}
