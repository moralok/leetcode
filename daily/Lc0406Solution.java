package daily;

import java.util.Arrays;

public class Lc0406Solution {
    public int[][] reconstructQueue(int[][] people) {
        // 从低到高排序
        int n = people.length;
        int[][] ret = new int[n][];
        Arrays.sort(people, (o1, o2) -> {
            if (o1[0] != o2[0]) {
                return o1[0] - o2[0];
            } else {
                return o2[1] - o1[1];
            }
        });
        for (int[] person : people) {
            int spaces = person[1] + 1;
            for (int i = 0; i < n; i++) {
                if (ret[i] == null) {
                    --spaces;
                    if (spaces == 0) {
                        ret[i] = person;
                    }
                }
            }
        }
        return ret;
    }
}
