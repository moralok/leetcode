package array.plus_one;

import java.util.Arrays;

public class Solution {

    public int[] plusOne(int[] digits) {
        for (int i = digits.length - 1; i >= 0; i--) {
            digits[i]++;
            digits[i] = digits[i] % 10;
            if (digits[i] != 0) return digits;
        }
        // 太巧妙了！
        digits = new int[digits.length + 1];
        digits[0] = 1;
        return digits;
    }

    public static void main(String[] args) {
        int[] case1 = new int[] {1,2,3};
        int[] case2 = new int[] {4,3,2,1};
        Solution solution = new Solution();
        System.out.println(Arrays.toString(solution.plusOne(case1)));
        System.out.println(Arrays.toString(solution.plusOne(case2)));
    }
}