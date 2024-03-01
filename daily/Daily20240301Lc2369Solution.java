package daily;

public class Daily20240301Lc2369Solution {

    public boolean validPartition(int[] nums) {
        int n = nums.length;
        boolean[] dp = new boolean[n];
        dp[0] = false;
        dp[1] = (nums[0] == nums[1]);
        if (n >= 3) {
            dp[2] = (nums[0] == nums[1] && nums[1] == nums[2])
                    || ((nums[1] - nums[0] == 1) && (nums[2] - nums[1] == 1));
        }
        for (int i = 3; i < n; i++) {
            dp[i] = (nums[i] == nums[i - 1] && dp[i - 2])
                    || (nums[i] == nums[i - 1] && nums[i - 1] == nums[i - 2] && dp[i - 3])
                    || ((nums[i] - nums[i - 1] == 1) && (nums[i - 1] - nums[i - 2] == 1) && dp[i - 3]);
        }
        return dp[n - 1];
    }

    public boolean validPartition1(int[] nums) {
        // 怎么内存消耗还变大了
        int n = nums.length;
        boolean[] dp = new boolean[3];
        dp[1] = (nums[0] == nums[1]);
        dp[2] = true;
        for (int i = 2; i < n; i++) {
            dp[i % 3] = (nums[i] == nums[i - 1] && dp[(i - 2) % 3])
                    || (nums[i] == nums[i - 1] && nums[i - 1] == nums[i - 2] && dp[i % 3])
                    || ((nums[i] - nums[i - 1] == 1) && (nums[i - 1] - nums[i - 2] == 1) && dp[i % 3]);
        }
        return dp[(n - 1) % 3];
    }

    public static void main(String[] args) {
        Daily20240301Lc2369Solution solution = new Daily20240301Lc2369Solution();
        int[] nums = {4, 4, 4, 5, 6};
        assert solution.validPartition(nums);
        assert solution.validPartition1(nums);
    }
}
