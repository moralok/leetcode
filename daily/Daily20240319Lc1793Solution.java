package daily;

public class Daily20240319Lc1793Solution {

    public int maximumScore(int[] nums, int k) {
        int n = nums.length;
        int i = k - 1, j = k + 1;
        int sum = nums[k];
        int min = nums[k];
        while (0 <= i || j < n) {
            if (i < 0) {
                min = Math.min(min, nums[j]);
                sum = Math.max(sum, min * (j - i));
                j++;
            } else if (j == n) {
                min = Math.min(min, nums[i]);
                sum = Math.max(sum, min * (j - i));
                i--;
            } else if (nums[i] < nums[j]) {
                min = Math.min(min, nums[j]);
                sum = Math.max(sum, min * (j - i));
                j++;
            } else {
                min = Math.min(min, nums[i]);
                sum = Math.max(sum, min * (j - i));
                i--;
            }
        }
        return sum;
    }

    public int maximumScore1(int[] nums, int k) {
        int n = nums.length;
        int i = k - 1, j = k + 1;
        int sum = nums[k];
        int min = nums[k];
        while (0 <= i || j < n) {
            while (0 <= i && nums[i] >= min) {
                i--;
            }
            while (j < n && nums[j] >= min) {
                j++;
            }
            sum = Math.max(sum, min * (j - i - 1));
            min = Math.max(i < 0 ? -1 : nums[i], j >= n ? -1 : nums[j]);
        }
        return sum;
    }

    public static void main(String[] args) {
        Daily20240319Lc1793Solution solution = new Daily20240319Lc1793Solution();
        int[] nums = new int[] {1,4,3,7,4,5};
        assert solution.maximumScore(nums, 3) == 15;
        assert solution.maximumScore1(nums, 3) == 15;
    }
}
