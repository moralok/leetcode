package hash_table.number_of_boomerangs;

import java.util.HashMap;
import java.util.Map;

public class NumberOfBoomerangs {
    public int numberOfBoomerangs(int[][] points) {
        int res = 0;
        for (int i = 0; i < points.length; i++) {
            Map<Integer, Integer> map = new HashMap<>();
            for (int j = 0; j < points.length; j++) {
                int distance = getDistance(points, i, j);
                if (distance != 0) {
                    map.put(distance, map.getOrDefault(distance, 0) + 1);
                }
            }
            for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
                res += entry.getValue() * (entry.getValue() - 1);
            }
        }
        return res;
    }

    private int getDistance(int[][] points, int i, int j) {
        return (points[i][0] - points[j][0]) * (points[i][0] - points[j][0]) + (points[i][1] - points[j][1]) * (points[i][1] - points[j][1]);
    }

    public static void main(String[] args) {
        NumberOfBoomerangs numberOfBoomerangs = new NumberOfBoomerangs();
        int[][] case1 = new int[][] {
            new int[] {0,0},
            new int[] {1,0},
            new int[] {2,0},
        };
        System.out.println(numberOfBoomerangs.numberOfBoomerangs(case1));
    }
}