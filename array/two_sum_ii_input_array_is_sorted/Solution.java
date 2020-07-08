package array.two_sum_ii_input_array_is_sorted;

import java.util.Arrays;

public class Solution {

    public int[] twoSum(int[] numbers, int target) {
        int lo = 0;
        int hi = numbers.length - 1;
        while (lo < hi) {
            int sum = numbers[lo] + numbers[hi];
            if (sum == target) {
                return new int[] {lo+1, hi+1};
            } else if (sum > target) {
                hi--;
            } else {
                lo++;
            }
        }
        return new int[]{-1, -1};
    }

    public static void main(String[] args) {
        int[] numbers = new int[] {2, 7, 11, 15};
        int target = 9;
        Solution solution = new Solution();
        System.out.println(Arrays.toString(solution.twoSum(numbers, target)));
    }
}