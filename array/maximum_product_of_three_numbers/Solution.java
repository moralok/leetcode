package array.maximum_product_of_three_numbers;

import java.util.Arrays;

public class Solution {

    public int maximumProduct(int[] nums) {
        Arrays.sort(nums);
        // 注意负数
        return Math.max(nums[0] * nums[1] * nums[nums.length - 1], nums[nums.length - 3] * nums[nums.length - 2] * nums[nums.length -1]);
    }

    public static void main(String[] args) {
        int[] case1 = new int[] {1,2,3};
        int[] case2 = new int[] {1,2,3,4};
        Solution solution = new Solution();
        System.out.println(solution.maximumProduct(case1));
        System.out.println(solution.maximumProduct(case2));
    }
}