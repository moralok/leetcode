package array.majority_element;

import java.util.Arrays;

public class Solution2 {
    public int majorityElement(int[] nums) {
        Arrays.sort(nums);
        return nums[nums.length/2];
    }

    public static void main(String[] args) {
        Solution2 solution = new Solution2();
        int[] case1 = new int[] {3,2,3};
        System.out.println(solution.majorityElement(case1));
        int[] case2 = new int[] {2,2,1,1,1,2,2};
        System.out.println(solution.majorityElement(case2));
    }
}