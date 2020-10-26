package top;

import java.util.Arrays;

public class Lc017Solution {
    public boolean containsDuplicate(int[] nums) {
        // O(nlog(n)) O(1)
        Arrays.sort(nums);
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] == nums[i-1]) {
                return true;
            }
        }
        return false;
    }
}
