package lcof.lcof053_i;

public class Lcof053ISolution2 {

    public int search(int[] nums, int target) {
        // 二分法的细节和变化还是很多的呀
        return helper(nums, target) - helper(nums, target - 1);
    }

    private int helper(int[] nums, int target) {
        int i = 0, j = nums.length - 1;
        while (i <= j) {
            int mid = i + (j - i) / 2;
            if (nums[mid] <= target) {
                i = mid + 1;
            } else {
                j = mid - 1;
            }
        }
        return i;
    }
}