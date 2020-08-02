package lcof.lcof003;

public class Lcof003Solution3 {
    public int findRepeatNumber(int[] nums) {
        // 利用原数组
        // 利用负值标记，因为0的存在,可以使用-n
        // O(n) O(1)
        int n = nums.length;
        for (int i = 0; i < n; i++) {
            int abs = Math.abs(nums[i]);
            if (abs == n) {
                abs = 0;
            }
            int tmp = nums[abs];
            if (tmp < 0) {
                return abs;
            } else if (tmp > 0) {
                nums[abs] = (-tmp);
            } else {
                nums[abs] = -n;
            }
        }
        return -1;
    }
}