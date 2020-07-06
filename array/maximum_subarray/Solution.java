package array.maximum_subarray;

public class Solution {
    
    public int maxSubArray(int[] nums) {
        int pre = 0;
        int res = nums[0];
        for (int i : nums) {
            pre = Math.max(pre + i, i);
            res = Math.max(res, pre);
        }
        return res;
    }

    public static void main(String[] args) {
        int[] nums = new int[] {-2,1,-3,4,-1,2,1,-5,4};
        Solution solution = new Solution();
        System.out.println(solution.maxSubArray(nums));
    }
}