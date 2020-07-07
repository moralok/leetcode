package array.merge_sorted_array;

import java.util.Arrays;

public class Solution2 {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int[] tmp = new int[m];
        System.arraycopy(nums1, 0, tmp, 0, m);
        int i = 0, j = 0, k = 0;
        while (i < m && j < n) {
            nums1[k++] = (nums2[j] < tmp[i]) ? nums2[j++] : tmp[i++];
        }
        if (i == m) {
            System.arraycopy(nums2, j, nums1, i + j, n - j);
        } else {
            System.arraycopy(tmp, i, nums1, i + j, m - i);
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