package array.majority_element;

import java.util.HashMap;
import java.util.Map;

public class Solution {

    public int majorityElement(int[] nums) {
        Map<Integer, Integer> counts = new HashMap<>();
        for (int i : nums) {
            if (counts.containsKey(i)) {
                counts.put(i, counts.get(i) + 1);
            } else {
                counts.put(i, 1);
            }
            if (counts.get(i) > nums.length / 2) {
                return i;
            }
        }
        return - 1;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] case1 = new int[] {3,2,3};
        System.out.println(solution.majorityElement(case1));
        int[] case2 = new int[] {2,2,1,1,1,2,2};
        System.out.println(solution.majorityElement(case2));
    }
}