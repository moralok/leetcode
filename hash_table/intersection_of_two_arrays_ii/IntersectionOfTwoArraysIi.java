package hash_table.intersection_of_two_arrays_ii;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class IntersectionOfTwoArraysIi {
    public int[] intersect(int[] nums1, int[] nums2) {
        if (nums1.length > nums2.length) {
            return intersect(nums2, nums1);
        }
        Map<Integer, Integer> map = new HashMap<>();
        for (int i : nums1) {
            map.put(i, map.getOrDefault(i, 0) + 1);
        }
        // 取稍短的长度
        int[] res = new int[nums1.length];
        int idx = 0;
        for (int i : nums2) {
            int count = map.getOrDefault(i, 0);
            if (count > 0) {
                res[idx++] = i;
                count--;
            }
            // 要更新抵消的个数
            map.put(i, count);
        }
        // 没怎么用过这个api
        return Arrays.copyOfRange(res, 0, idx);
    }

    public static void main(String[] args) {
        IntersectionOfTwoArraysIi intersectionOfTwoArrays = new IntersectionOfTwoArraysIi();
        int[] case11 = new int[] {1,2,2,1};
        int[] case12 = new int[] {2,2};
        System.out.println(Arrays.toString(intersectionOfTwoArrays.intersect(case11, case12)));
        int[] case21 = new int[] {4,9,5};
        int[] case22 = new int[] {9,4,9,8,4};
        System.out.println(Arrays.toString(intersectionOfTwoArrays.intersect(case21, case22)));
    }
}