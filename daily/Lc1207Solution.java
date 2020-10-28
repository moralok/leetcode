package daily;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class Lc1207Solution {
    public boolean uniqueOccurrences(int[] arr) {
        // 哈希表
        Map<Integer, Integer> map = new HashMap<>();
        for (int i : arr) {
            map.put(i, map.getOrDefault(i, 0) + 1);
        }
        Set<Integer> count = new HashSet<>();
        for (Integer i : map.values()) {
            if (count.contains(i)) {
                return false;
            }
            count.add(i);
        }
        return true;
    }
}
