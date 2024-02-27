package daily;

import common.TreeNode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Daily20240227Lc2867Solution {

    // 埃氏筛
    public static final int N = 100001;
    private static boolean[] isPrime = new boolean[N];

    static {
        Arrays.fill(isPrime, true);
        isPrime[1] = false;
        for (int i = 2; i * i < N; i++) {
            if (isPrime[i]) {
                for (int j = i * i; j < N; j += i) {
                    isPrime[j] = false;
                }
            }
        }
    }


    public long countPaths(int n, int[][] edges) {
        // 初始化
        List<Integer>[] G = new ArrayList[n + 1];
        for (int i = 0; i < n + 1; i++) {
            G[i] = new ArrayList<>();
        }
        for (int[] edge : edges) {
            int i = edge[0], j = edge[1];
            G[i].add(j);
            G[j].add(i);
        }

        long res = 0;
        long[] count = new long[n + 1];
        List<Integer> seen = new ArrayList<>();
        for (int i = 1; i <= n; i++) {
            if (!isPrime[i]) {
                continue;
            }
            long cur = 0;
            for (Integer p : G[i]) {
                if (isPrime[p]) {
                    continue;
                }
                if (count[p] == 0) {
                    seen.clear();
                    dfs(G, seen, p, i);
                    int size = seen.size();
                    for (Integer s : seen) {
                        count[s] = size;
                    }
                }
                res += count[p] * cur;
                cur += count[p];
            }
            res += cur;
        }
        return res;
    }

    private void dfs(List<Integer>[] G, List<Integer> seen, int i, int pre) {
        seen.add(i);
        for (Integer p : G[i]) {
            if (p != pre && !isPrime[p]) {
                dfs(G, seen, p, i);
            }
        }
    }
}
