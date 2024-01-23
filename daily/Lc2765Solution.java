package daily;

public class Lc2765Solution {

    public int alternatingSubarray(int[] nums) {
        int res = -1;
        int n = nums.length;
        int start = 0;
        for (int i = 1; i < n; i++) {
            int len = i - start + 1;
            if (nums[i] - nums[start] == (len - 1) % 2) {
                res = Math.max(res, len);
            } else {
                if (nums[i] - nums[i - 1] == 1) {
                    start = i - 1;
                    res = Math.max(res , 2);
                } else {
                    start = i;
                }
            }
        }
        return res;
    }

    public static void main(String[] args) {
        Lc2765Solution solution = new Lc2765Solution();
        int[] nums = new int[] {2,3,4,3,4};
        assert solution.alternatingSubarray(nums) == 4;
    }
}
