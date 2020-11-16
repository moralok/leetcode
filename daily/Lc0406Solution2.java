package daily;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Lc0406Solution2 {
    public int[][] reconstructQueue(int[][] people) {
        // 从高到低排序
        int n = people.length;
        Arrays.sort(people, (o1, o2) -> {
            if (o1[0] != o2[0]) {
                return o2[0] - o1[0];
            } else {
                return o1[1] - o2[1];
            }
        });
        List<int[]> ret = new ArrayList<>();
        for (int[] person : people) {
            ret.add(person[1], person);
        }
        return ret.toArray(new int[n][]);
    }
}
