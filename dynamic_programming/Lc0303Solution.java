package dynamic_programming;

public class Lc0303Solution {

    int[] dp;
    
    public Lc0303Solution(int[] nums) {
        dp = new int[nums.length + 1];
        dp[0] = 0;
        for (int i = 0; i < nums.length; i++) {
            dp[i + 1] = dp[i] + nums[i];
        }
    }
    
    public int sumRange(int i, int j) {
        return dp[j+1] - dp[i];
    }
}
