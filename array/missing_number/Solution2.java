package array.missing_number;

import java.util.Arrays;

public class Solution2 {

    public int missingNumber(int[] nums) {
        Arrays.sort(nums);
        if (nums[nums.length-1] != nums.length) {
            return nums.length;
        }
        if (nums[0] != 0) {
            return 0;
        }
        for (int i = 1; i < nums.length; i++) {
            int expected = nums[i-1] + 1;
            if (nums[i] != expected) {
                return expected;
            }
        }

        return -1;
    }

    public static void main(String[] args) {
        int[] case1 = new int[] {3,0,1};
        int[] case2 = new int[] {9,6,4,2,3,5,7,0,1};
        Solution2 solution = new Solution2();
        System.out.println(solution.missingNumber(case1));
        System.out.println(solution.missingNumber(case2));
    }
}