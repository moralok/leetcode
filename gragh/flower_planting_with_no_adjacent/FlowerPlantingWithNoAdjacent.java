package gragh.flower_planting_with_no_adjacent;

import java.util.LinkedList;

@SuppressWarnings("unchecked")
public class FlowerPlantingWithNoAdjacent {
    public int[] gardenNoAdj(int N, int[][] paths) {
        // 邻接表
        int[] ans = new int[N];
        LinkedList<Integer>[] adj = (LinkedList<Integer>[]) new LinkedList[N];
        for (int i = 0; i < adj.length; i++) {
            adj[i] = new LinkedList<>();
        }
        for (int[] tmp : paths) {
            adj[tmp[0] - 1].add(tmp[1] - 1);
            adj[tmp[1] - 1].add(tmp[0] - 1);
        }
        for (int i = 0; i < adj.length; i++) {
            boolean[] color = new boolean[5];
            for (Integer id : adj[i]) {
                color[ans[id]] = true;
            }
            for (int k = 1; k < color.length; k++) {
                if (!color[k]) {
                    ans[i] = k;
                    break;
                }
            }
        }
        return ans;
    }
}