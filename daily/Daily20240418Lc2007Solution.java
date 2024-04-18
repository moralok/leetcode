package daily;

import java.util.*;

public class Daily20240418Lc2007Solution {

    public int[] findOriginalArray(int[] changed) {
        Arrays.sort(changed);
        Map<Integer, Integer> count = new HashMap<>();
        for (int a : changed) {
            count.put(a, count.getOrDefault(a, 0) + 1);
        }
        int[] res = new int[changed.length / 2];
        int i = 0;
        for (int a : changed) {
            if (count.get(a) == 0) {
                continue;
            }
            count.put(a, count.get(a) - 1);
            if (count.getOrDefault(a * 2, 0) == 0) {
                return new int[0];
            }
            count.put(a * 2, count.get(a * 2) - 1);
            res[i++] = a;
        }
        return res;
    }
}
