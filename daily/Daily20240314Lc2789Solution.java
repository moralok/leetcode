package daily;

public class Daily20240314Lc2789Solution {

    public long maxArrayValue(int[] nums) {
        long res;
        int n = nums.length;
        res = nums[n - 1];
        for (int i = n - 2; i >= 0; i--) {
            if (nums[i] <= res) {
                res += nums[i];
            } else {
                res = nums[i];
            }
        }
        return res;
    }

    public static void main(String[] args) {
        Daily20240314Lc2789Solution solution = new Daily20240314Lc2789Solution();
        int[] nums = new int[] {2,3,7,9,3};
        assert solution.maxArrayValue(nums) == 21;
        nums = new int[] {5,3,3};
        assert solution.maxArrayValue(nums) == 11;
    }
}
