package practice2023.sort_an_array;

import java.util.Arrays;

public class Lc0912SolutionHeap {

    public int[] sortArray(int[] nums) {
        int size = nums.length;
        heapify(nums, size);
        for (int i = 0; i < nums.length; i++) {
            swap(nums, 0, --size);
            sink(nums, 0, size);
        }
        return nums;
    }

    private void sink(int[] nums, int i, int size) {
        int j = 2 * i + 1;
        while (j < size) {
            if (j + 1 < size && nums[j + 1] > nums[j]) {
                j++;
            }
            if (nums[i] >= nums[j]) {
                break;
            }
            swap(nums, i, j);
            i = j;
            j = 2 * i + 1;
        }
    }

    private void swim(int[] nums, int i) {
        while (i > 0) {
            int j = (i - 1) / 2;
            if (nums[i] <= nums[j]) {
                break;
            }
            swap(nums, i, j);
            i = j;
        }
    }

    private void heapify(int[] nums, int size) {
        int n = size - 2 / 2;
        while (n >= 0) {
            sink(nums, n--, size);
        }
    }

    private void swap(int[] nums, int i, int j) {
        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
    }

    public static void main(String[] args) {
        int[] nums = new int[] {5,2,3,1};
        Lc0912SolutionHeap lc0912SolutionHeap = new Lc0912SolutionHeap();
        lc0912SolutionHeap.sortArray(nums);
        System.out.println(Arrays.toString(nums));
    }
}
