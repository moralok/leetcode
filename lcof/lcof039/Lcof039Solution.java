package lcof.lcof039;

import java.util.Arrays;

public class Lcof039Solution {

    public int majorityElement(int[] nums) {
        // 排序法
        Arrays.sort(nums);
        return nums[(nums.length - 1) / 2];
    }
}