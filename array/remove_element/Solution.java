package array.remove_element;

/**
 * Solution
 */
public class Solution {

    public int removeElement(int[] nums, int val) {
        int j = 0;
        for (int i = 0; i < nums.length; i++) {
            if (val != nums[i]) {
                // 不需要交换
                nums[j++] = nums[i]; 
            }
        }
        return j;
    }

    public static void main(String[] args) {
        int[] case1 = new int[] {3,2,2,3};
        int[] case2 = new int[] {0,1,2,2,3,0,4,2};
        Solution solution = new Solution();
        System.out.println(solution.removeElement(case1, 3));
        System.out.println(solution.removeElement(case2, 2));
    }
}