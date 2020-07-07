package array.merge_sorted_array;

import java.util.Arrays;

public class Solution3 {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int i = m - 1;
        int j = n - 1;
        int k = m + n - 1;
        while (j >= 0) {
            if (i >= 0 && nums1[i] > nums2[j]) {
                nums1[k--] = nums1[i--];
            } else {
                nums1[k--] = nums2[j--];
            }
        }
    }

    public static void main(String[] args) {
        int[] nums1 = new int[] {1, 2, 5, 6, 0, 0};
        int[] nums2 = new int[] {3, 4};
        Solution solution = new Solution();
        solution.merge(nums1, 4, nums2, 2);
        System.out.println(Arrays.toString(nums1));
    }
}