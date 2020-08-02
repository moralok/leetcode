package lcof.lcof003;

import java.util.HashSet;
import java.util.Set;

public class Lcof003Solution {
    public int findRepeatNumber(int[] nums) {
        // Set
        // O(n) O(n)
        Set<Integer> set = new HashSet<>();
        for (int num : nums) {
            if (!set.contains(num)) {
                set.add(num);
            } else {
                return num;
            }
        }
        return -1;
    }
}