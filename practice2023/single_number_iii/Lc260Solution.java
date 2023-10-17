package practice2023.single_number_iii;

import practice2023.sort_an_array.Lc0912SolutionHeap;

import java.util.Arrays;

public class Lc260Solution {

    public int[] singleNumber(int[] nums) {
        int eorAll = 0;
        for (int i = 0; i < nums.length; i++) {
            eorAll ^= nums[i];
        }
        int rightOne = eorAll & (-eorAll);
        int eorPart = 0;
        for (int i = 0; i < nums.length; i++) {
            if ((nums[i] & rightOne) == 0) {
                eorPart ^= nums[i];
            }
        }
        return new int[] {eorPart, eorPart ^ eorAll};
    }

    public static void main(String[] args) {
        int[] nums = new int[] {2,1,2,3,4,1};
        Lc260Solution solution = new Lc260Solution();
        int[] ans = solution.singleNumber(nums);
        System.out.println(Arrays.toString(ans));
    }
}
