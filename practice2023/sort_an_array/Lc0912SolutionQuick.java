package practice2023.sort_an_array;

import java.util.Arrays;

/**
 * 知道思路换个写法就花了27分钟
 * leetcode 不用荷兰国旗改进会超时
 */
public class Lc0912SolutionQuick {
    
    public int[] sortArray(int[] nums) {
        sort(nums, 0, nums.length - 1);
        return nums;
    }

    private void sort(int[] nums, int left, int right) {
        if (left >= right) {
            return;
        }
        randomSelect(nums, left, right);
        int j = partition(nums, left, right);
        sort(nums, left, j - 1);
        sort(nums, j + 1, right);
    }

    private int partition(int[] nums, int left, int right) {
        int i = left + 1, j = left + 1;
        int val = nums[left];
        while (j <= right) {
            if (nums[j] <= val) {
                swap(nums, i++, j);
            }
            j++;
        }
        swap(nums, left, i - 1);
        return i - 1;
    }

    private void swap(int[] nums, int i, int j) {
        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
    }

    private void randomSelect(int[] nums, int left, int right) {
        int index = (int) (left + Math.random() * (right - left + 1));
        swap(nums, left, index);
    }

    public static void main(String[] args) {
        int[] nums = new int[] {5,2,3,1};
        Lc0912SolutionQuick lc0912SolutionQuick = new Lc0912SolutionQuick();
        lc0912SolutionQuick.sortArray(nums);
        System.out.println(Arrays.toString(nums));
    }
}
