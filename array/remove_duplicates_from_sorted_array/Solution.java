package array.remove_duplicates_from_sorted_array;

public class Solution {
    public int removeDuplicates(int[] nums) {
        int i = 0;
        for (int j = 1; j < nums.length; j++) {
            if (nums[i] != nums[j]) {
                i++;
                nums[i] = nums[j];
            }
        }
        return i + 1;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] a1 = new int[] {1,1,2};
        int l1 = solution.removeDuplicates(a1);
        for (int i = 0; i < l1; i++) {
            System.out.println(a1[i]);
        }

        int[] a2 = new int[] {0,0,1,1,1,2,2,3,3,4};
        int l2 = solution.removeDuplicates(a2);
        for (int i = 0; i < l2; i++) {
            System.out.println(a2[i]);
        }
    }
}