package daily;

import java.util.HashMap;
import java.util.Map;

public class Lc0447Solution {

    public int numberOfBoomerangs(int[][] points) {
        Map<Integer, Integer> counts = new HashMap<>();
        int ret = 0;
        for (int[] p : points) {
            counts.clear();
            for (int[] anotherP : points) {
                int lengthSquare = (int) Math.pow(anotherP[0] - p[0], 2) + (int) Math.pow(anotherP[1] - p[1], 2);
                Integer count = counts.getOrDefault(lengthSquare, 0);
                counts.put(lengthSquare, ++count);
            }
            for (Map.Entry<Integer, Integer> entry : counts.entrySet()) {
                int count = entry.getValue();
                if (count > 1) {
                    ret += (count * (count - 1));
                }
            }
        }
        return ret;
    }

    public static void main(String[] args) {
        Lc0447Solution solution = new Lc0447Solution();
        int[][] points;

        points = new int[][] {
                {0,0},{1,0},{2,0}
        };
        assert solution.numberOfBoomerangs(points) == 2;
    }
}
