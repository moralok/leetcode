package lcof.lcof042;

public class Lcof042Solution {
    public int maxSubArray(int[] nums) {
        // 动态规划
        int pre = nums[0], res = nums[0];
        for (int i = 1; i < nums.length; i++) {
            if (pre < 0) {
                pre = nums[i];
            } else {
                pre = pre + nums[i];
            }
            res = Math.max(pre, res);
        }
        return res;
    }
}