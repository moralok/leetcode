package hash_table.intersection_of_two_arrays;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class IntersectionOfTwoArrays {
    public int[] intersection(int[] nums1, int[] nums2) {
        Set<Integer> set1 = new HashSet<>();
        Set<Integer> set2 = new HashSet<>();
        for (Integer integer : nums1) {
            set1.add(integer);
        }
        for (Integer integer : nums2) {
            set2.add(integer);
        }
        set1.retainAll(set2);
        int[] res = new int[set1.size()];
        int index = 0;
        for (int i : set1) {
            res[index++] = i;
        }
        return res;
    }

    public static void main(String[] args) {
        IntersectionOfTwoArrays intersectionOfTwoArrays = new IntersectionOfTwoArrays();
        int[] case11 = new int[] {1,2,2,1};
        int[] case12 = new int[] {2,2};
        System.out.println(Arrays.toString(intersectionOfTwoArrays.intersection(case11, case12)));
        int[] case21 = new int[] {4,9,5};
        int[] case22 = new int[] {9,4,9,8,4};
        System.out.println(Arrays.toString(intersectionOfTwoArrays.intersection(case21, case22)));
    }
}