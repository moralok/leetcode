package daily;

import java.util.Set;
import java.util.HashSet;

public class Lc0349Solution {
    public int[] intersection(int[] nums1, int[] nums2) {
        Set<Integer> set1 = new HashSet<>(), set2 = new HashSet<>();
        for (int i : nums1) {
            set1.add(i);
        }
        for (int i : nums2) {
            set2.add(i);
        }
        set1.retainAll(set2);
        int[] arr = new int[set1.size()];
        int idx = 0;
        for (int i : set1) {
            arr[idx++] = i;
        }
        return arr;
    }
}