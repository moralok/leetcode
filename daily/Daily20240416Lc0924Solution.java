package daily;

import java.util.*;

public class Daily20240416Lc0924Solution {

    public int minMalwareSpread(int[][] graph, int[] initial) {
        CC cc = new CC(graph, initial);
        int max = 0;
        Set<Integer> candidates = new HashSet<>();
        for (int i = 0; i < cc.size.length; i++) {
            if (cc.size[i] > max) {
                max = cc.size[i];
                candidates = new HashSet<>();
                candidates.add(i);
            } else if (cc.size[i] == max) {
                candidates.add(i);
            }
        }
        Arrays.sort(initial);
        for (int i : initial) {
            if (candidates.contains(cc.id[i])) {
                return i;
            }
        }
        return 0;
    }

    private static class CC {
        private final boolean[] marked;
        private final int[] id;
        private int count;
        private final int[] size;

        public CC(int[][] graph, int[] initial) {
            int n = graph.length;
            marked = new boolean[n];
            size = new int[n];
            id = new int[n];
            for (int i : initial) {
                if (marked[i]) {
                    size[id[i]] = 0;
                } else {
                    dfs(graph, i);
                    count++;
                }
            }
        }

        private void dfs(int[][] graph, int v) {
            marked[v] = true;
            id[v] = count;
            size[count]++;
            for (int i = 0; i < graph.length; i++) {
                if (graph[v][i] == 1 && !marked[i]) {
                    dfs(graph, i);
                }
            }
        }
    }

    public static void main(String[] args) {
        Daily20240416Lc0924Solution solution = new Daily20240416Lc0924Solution();
        int[][] graph = new int[][]{{1, 1, 0}, {1, 1, 0}, {0, 0, 1}};
        int[] initial = new int[]{0, 1};
        assert solution.minMalwareSpread(graph, initial) == 0;
        graph = new int[][]{{1, 0, 0}, {0, 1, 0}, {0, 0, 1}};
        initial = new int[]{0, 2};
        assert solution.minMalwareSpread(graph, initial) == 0;
        graph = new int[][]{{1, 1, 1}, {1, 1, 1}, {1, 1, 1}};
        initial = new int[]{1, 2};
        assert solution.minMalwareSpread(graph, initial) == 1;
    }
}
