package array.missing_number;

public class Solution {

    public int missingNumber(int[] nums) {
        // 有溢出风险
        int expectedNum = (1 + nums.length) * nums.length / 2;
        int actualSum = 0;
        for (int i = 0; i < nums.length; i++) {
            actualSum += nums[i];
        }
        return expectedNum - actualSum;
    }

    public static void main(String[] args) {
        int[] case1 = new int[] {3,0,1};
        int[] case2 = new int[] {9,6,4,2,3,5,7,0,1};
        Solution solution = new Solution();
        System.out.println(solution.missingNumber(case1));
        System.out.println(solution.missingNumber(case2));
    }
}