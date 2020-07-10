package array.move_zeroes;

import java.util.Arrays;

public class Solution2 {
    // 对于避免写操作的局部优化，增加了出现bug的几率
    // 而且认同部分评论，因数组具体情况不同，双指针法的两种方法的操作成本也不相同，并不能说本方法必然是最优解
    public void moveZeroes(int[] nums) {
        for (int i = 0, j = 0; i < nums.length; i++) {
            if (nums[i] != 0 && i != j) {
                swap(nums, i, j++);
            } else if (nums[i] != 0 && i == j) {
                j++;
            }
        }
    }

    private void swap(int[] nums, int i, int j) {
        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
    }

    public static void main(String[] args) {
        int[] case1 = new int[] {0,1,0,3,12};
        int[] case2 = new int[] {1};
        int[] case3 = new int[] {2,1};
        Solution2 solution = new Solution2();
        solution.moveZeroes(case1);
        System.out.println(Arrays.toString(case1));
        solution.moveZeroes(case2);
        System.out.println(Arrays.toString(case2));
        solution.moveZeroes(case3);
        System.out.println(Arrays.toString(case3));
    }
}