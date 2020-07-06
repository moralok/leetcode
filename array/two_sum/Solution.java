package array.two_sum;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class Solution {
    
    public int[] twoSum(int[] nums, int target) {
        int[] res = new int[2];
        Map<Integer, Integer> map = new HashMap<>();
        int another = 0;
        for (int i = 0; i < nums.length; i++) {
            another = target - nums[i];
            Integer anotherIndex = map.get(another);
            if (anotherIndex != null) {
                res[0] = anotherIndex;
                res[1] = i;
                return res;
            }
            map.put(nums[i], i);
        }
        return null;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{2, 7, 11, 15};
        int target = 9;
        Solution solution = new Solution();
        int[] res = solution.twoSum(nums, target);
        System.out.println(Arrays.toString(res));
    }
}