package array.move_zeroes;

import java.util.Arrays;

public class Solution {
    public void moveZeroes(int[] nums) {
        int j = 0;
        for (int i = 0; i < nums.length; i++) {
            // 如果开始连续非0，不处理，但是j还是要自增的
            // 做额外的优化时，容易引入额外的判断和处理，也增加了出现bug的几率
            // 我去！这bug。。。
            if (nums[i] != 0 && i != j) {
                nums[j++] = nums[i];
            } else if (nums[i] != 0 && i == j) {
                j++;
            }
        }
        for (int i = j; i < nums.length; i++) {
            // 处理0部分时，遇到非0才修改为0
            if (nums[i] != 0) {
                nums[i] = 0;
            }
        }
    }

    public static void main(String[] args) {
        int[] case1 = new int[] {0,1,0,3,12};
        int[] case2 = new int[] {1};
        int[] case3 = new int[] {2,1};
        Solution solution = new Solution();
        solution.moveZeroes(case1);
        System.out.println(Arrays.toString(case1));
        solution.moveZeroes(case2);
        System.out.println(Arrays.toString(case2));
        solution.moveZeroes(case3);
        System.out.println(Arrays.toString(case3));
    }
}