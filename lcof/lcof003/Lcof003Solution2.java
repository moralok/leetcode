package lcof.lcof003;

public class Lcof003Solution2 {
    public int findRepeatNumber(int[] nums) {
        // 利用原数组
        // 刚开始只想到了利用负值标记，见Solution3
        // O(n) O(1)
        for (int i = 0; i < nums.length; i++) {
            while (nums[i] != i) {
                int tmp = nums[nums[i]];
                if (tmp == nums[i]) {
                    return tmp;
                }
                // swap
                nums[nums[i]] = nums[i];
                nums[i] = tmp;
            }
        }
        return -1;
    }
}