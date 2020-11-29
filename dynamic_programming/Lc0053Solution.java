package dynamic_programming;

public class Lc0053Solution {
    public int maxSubArray(int[] nums) {
        // ret = max{f(i)}
        // 1. 转移方程：f(i) = max{f(i-1)+ai, ai}
        if (nums == null || nums.length == 0) {
            return 0;
        }
        int max = Integer.MIN_VALUE;
        int sum = 0;
        for (int i : nums) {
            sum = sum < 0 ? i : sum + i;
            max = Math.max(max, sum);
        }
        return max;
    }

    public static void main(String[] args) {
        Lc0053Solution solution = new Lc0053Solution();
        int[] nums = new int[]{-2,1,-3,4,-1,2,1,-5,4};
        System.out.println(solution.maxSubArray(nums));
    }
}
