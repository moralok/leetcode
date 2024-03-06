package daily;

public class Daily20240306Lc2917Solution {

    public int findKOr(int[] nums, int k) {
        int pow = 1;
        int res = 0;
        for (int i = 0; i < 32; i++) {
            int count = 0;
            for (int j = 0; j < nums.length; j++) {
                if ((nums[j] & 1) > 0) {
                    count++;
                }
                nums[j] >>= 1;
            }
            if (count >= k) {
                res += pow;
            }
            pow <<= 1;
        }
        return res;
    }

    public static void main(String[] args) {
        Daily20240306Lc2917Solution solution = new Daily20240306Lc2917Solution();
        int[] nums = new int[] {7,12,9,8,9,15};
        int k = 4;
        assert solution.findKOr(nums, k) == 9;
    }
}
