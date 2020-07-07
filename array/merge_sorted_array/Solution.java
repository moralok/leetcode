package array.merge_sorted_array;

import java.util.Arrays;

public class Solution {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        System.arraycopy(nums2, 0, nums1, m, n);
        Arrays.sort(nums1);
    }

    public static void main(String[] args) {
        int[] nums1 = new int[] {1, 2, 5, 6, 0, 0};
        int[] nums2 = new int[] {3, 4};
        Solution solution = new Solution();
        solution.merge(nums1, 4, nums2, 2);
        System.out.println(Arrays.toString(nums1));
    }
}