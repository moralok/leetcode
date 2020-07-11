package array.missing_number;

import java.util.HashSet;
import java.util.Set;

public class Solution3 {

    public int missingNumber(int[] nums) {
        Set<Integer> set = new HashSet<>();
        for (int i : nums) {
            set.add(i);
        }
        for (int i = 0; i < nums.length + 1; i++) {
            if (!set.contains(i)) {
                return i;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        int[] case1 = new int[] {3,0,1};
        int[] case2 = new int[] {9,6,4,2,3,5,7,0,1};
        Solution3 solution = new Solution3();
        System.out.println(solution.missingNumber(case1));
        System.out.println(solution.missingNumber(case2));
    }
}