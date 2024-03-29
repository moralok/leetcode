package daily;

public class Daily20240329Lc2908Solution {

    public int minimumSum(int[] nums) {
        int n = nums.length;
        int[] left = new int[n];
        int[] right = new int[n];
        left[0] = Integer.MAX_VALUE;
        right[n - 1] = Integer.MAX_VALUE;
        for (int i = 1; i < n; i++) {
            left[i] = Math.min(left[i - 1], nums[i - 1]);
        }
        for (int i = n - 2; i >= 0; i--) {
            right[i] = Math.min(right[i + 1], nums[i + 1]);
        }
        int res = Integer.MAX_VALUE;
        for (int i = 0; i < n; i++) {
            if (left[i] < nums[i] && right[i] < nums[i]) {
                res = Math.min(res, left[i] + nums[i] + right[i]);
            }
        }
        return res == Integer.MAX_VALUE ? -1 : res;
    }

    public static void main(String[] args) {
        Daily20240329Lc2908Solution solution = new Daily20240329Lc2908Solution();
        int[] nums = new int[]{8, 6, 1, 5, 3};
        assert solution.minimumSum(nums) == 9;
        nums = new int[]{5, 4, 8, 7, 10, 2};
        assert solution.minimumSum(nums) == 13;
    }
}
