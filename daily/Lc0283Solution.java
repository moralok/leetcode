package daily;

public class Lc0283Solution {

    public void moveZeroes(int[] nums) {
        int i = 0, j = 0;
        for (; j < nums.length; j++) {
            if (nums[j] != 0) {
                int tmp = nums[i];
                nums[i] = nums[j];
                nums[j] = tmp;
                i++;
            }
        }
    }
}