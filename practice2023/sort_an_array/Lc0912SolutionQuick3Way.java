package practice2023.sort_an_array;

import java.util.Arrays;

public class Lc0912SolutionQuick3Way {

    public int[] sortArray(int[] nums) {
        sort(nums, 0, nums.length - 1);
        return nums;
    }

    private void sort(int[] nums, int left, int right) {
        if (left >= right) {
            return;
        }

        randomSelect(nums, left, right);

        // 切分
        int lt = left;
        int gt = right;
        int i = left + 1;
        int val = nums[left];
        while (i <= gt) {
            if (nums[i] < val) {
                swap(nums, i++, lt++);
            } else if (nums[i] == val) {
                i++;
            } else {
                swap(nums, i, gt--);
            }
        }

        sort(nums, left, lt - 1);
        sort(nums, gt + 1, right);
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
        // int[] nums = new int[] {5,1,1,2,0,0,3,5,6,7,8,4,3,65,7,8,4,3,6,7,877,4,7,4,67,78,3,5,76,8,5,7,5,6,7};
        Lc0912SolutionQuick3Way lc0912SolutionQuick3Way = new Lc0912SolutionQuick3Way();
        lc0912SolutionQuick3Way.sortArray(nums);
        System.out.println(Arrays.toString(nums));
    }
}
