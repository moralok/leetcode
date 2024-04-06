package daily;

import java.util.Arrays;

public class Daily20240406Lc1483Solution {

    private static class TreeAncestor {

        private final int[][] ancestor;

        public TreeAncestor(int n, int[] parent) {
            ancestor = new int[n][16];
            for (int i = 0; i < n; i++) {
                Arrays.fill(ancestor[i], -1);
            }
            for (int i = 0; i < n; i++) {
                ancestor[i][0] = parent[i];
            }
            for (int i = 1; i < 16; i++) {
                for (int j = 0; j < n; j++) {
                    ancestor[j][i] = ancestor[j][i - 1] == -1 ? -1 : ancestor[ancestor[j][i - 1]][i - 1];
                }
            }
        }

        public int getKthAncestor(int node, int k) {
            for (int i = 0; i < 16; i++) {
                if ((k & (1 << i)) > 0) {
                    node = ancestor[node][i];
                    if (node == -1) {
                        break;
                    }
                }
            }
            return node;
        }
    }
}
