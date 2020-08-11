package lcof.lcof061;

import java.util.HashSet;
import java.util.Set;

public class Lcof061Solution {
    public boolean isStraight(int[] nums) {
        // 转化为 1. 不重复 2. 最大差小于5
        Set<Integer> repeat = new HashSet<>();
        int max = 0, min = 14;
        for (int num : nums) {
            if (num == 0) {
                continue;
            }
            max = Math.max(max, num);
            min = Math.min(min, num);
            if (repeat.contains(num)) {
                return false;
            }
            repeat.add(num);
        }
        return max - min < 5;
    }
}