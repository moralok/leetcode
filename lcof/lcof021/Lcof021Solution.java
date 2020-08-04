package lcof.lcof021;

public class Lcof021Solution {
    public int[] exchange(int[] nums) {
        // 首尾指针法
        int left = 0, right = nums.length - 1;
        while (left < right) {
            if ((nums[left] & 1) == 1) {
                left++;
                continue;
            }
            if ((nums[right] & 1) == 0) {
                right--;
                continue;
            }
            int tmp = nums[right];
            nums[right--] = nums[left];
            nums[left++] = tmp;
        }
        return nums;
    }
}