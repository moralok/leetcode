package array.find_all_numbers_disappeared_in_an_array;

import java.util.ArrayList;
import java.util.List;

public class Solution {

    public List<Integer> findDisappearedNumbers(int[] nums) {
        for (int i = 0; i < nums.length; i++) {
            int newIndex = Math.abs(nums[i]) - 1;
            if (nums[newIndex] > 0) {
                nums[newIndex] *= -1;
            }
        }
        List<Integer> res = new ArrayList<>();
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] > 0) {
                res.add(i+1);
            }
        }
        return res;
    }

    public static void main(String[] args) {
        int[] case1 = new int[] {4,3,2,7,8,2,3,1};
        Solution solution = new Solution();
        System.out.println(solution.findDisappearedNumbers(case1));
    }
}