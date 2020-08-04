package lcof.lcof021;

public class Lcof021Solution2 {
    public int[] exchange(int[] nums) {
        // 快慢指针法
        int slow = 0, fast = 0;
        while (slow < nums.length && (nums[slow] & 1) == 1) {
            slow++;
        }
        fast = slow + 1;
        while (fast < nums.length) {
            if ((nums[fast] & 1) == 1) {
                int tmp = nums[fast];
                nums[fast] = nums[slow];
                nums[slow++] = tmp;
            }
            fast++;
        }
        return nums;
    }
}