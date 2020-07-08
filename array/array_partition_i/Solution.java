package array.array_partition_i;

import java.util.Arrays;

public class Solution {
    public int arrayPairSum(int[] nums) {
        Arrays.sort(nums);
        int sum = 0;
        for (int i = 0; i < nums.length; i = i + 2) {
            sum += nums[i];
        }
        return sum;
    }

    public static void main(String[] args) {
        int[] case1 = new int[] {1,4,3,2};
        Solution solution = new Solution();
        System.out.println(solution.arrayPairSum(case1));
    }
}