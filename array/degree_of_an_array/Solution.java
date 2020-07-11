package array.degree_of_an_array;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public class Solution {

    public int findShortestSubArray(int[] nums) {
        Map<Integer, Integer> left = new HashMap<>();
        Map<Integer, Integer> right = new HashMap<>();
        Map<Integer, Integer> count = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            if (!left.containsKey(nums[i])) {
                left.put(nums[i], i);
            }
            right.put(nums[i], i);
            count.put(nums[i], count.getOrDefault(nums[i], 0) + 1);
        }
        int res = nums.length;
        Integer degree = Collections.max(count.values());
        for (int x : count.keySet()) {
            if (count.get(x) == degree) {
                res = Math.min(res, right.get(x) - left.get(x) + 1);
            }
        }
        return res;
    }

    public static void main(String[] args) {
        int[] case1 = new int[] {1, 2, 2, 3, 1};
        int[] case2 = new int[] {1,2,2,3,1,4,2};
        Solution solution = new Solution();
        System.out.println(solution.findShortestSubArray(case1));
        System.out.println(solution.findShortestSubArray(case2));
    }
}