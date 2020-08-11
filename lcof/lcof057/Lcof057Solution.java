package lcof.lcof057;

public class Lcof057Solution {
    public int[] twoSum(int[] nums, int target) {
        int[] res = new int[2];
        int i = 0, j = nums.length - 1;
        while (i < j) {
            int tmp = target - nums[i];
            if (tmp > nums[j]) {
                i++;
            } else if (tmp < nums[j]) {
                j--;
            } else {
                res[0] = nums[i];
                res[1] = nums[j];
                break;
            }
        }
        return res;
    }
}