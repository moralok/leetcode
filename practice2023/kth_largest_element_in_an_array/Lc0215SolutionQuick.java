package practice2023.kth_largest_element_in_an_array;

public class Lc0215SolutionQuick {
    
    public int findKthLargest(int[] nums, int k) {
        return findKthLargest(nums, k, 0, nums.length - 1);
    }

    private int findKthLargest(int[] nums, int k, int left, int right) {
        if (left == right) {
            // 正常情况不会出现 left > right
            return nums[left];
        }
        randomSelect(nums, left, right);
        int p = partition(nums, left, right);
        // 坐标要计算正确
        if (p == nums.length - k) {
            return nums[p];
        } else if (p < nums.length - k) {
            return findKthLargest(nums, k, p + 1, right);
        } else {
            return findKthLargest(nums, k, left, p - 1);
        }
    }

    private int partition(int[] nums, int left, int right) {
        int val = nums[left];
        int i = left + 1, j = left + 1;
        while (j <= right) {
            if (nums[j] <= val) {
                swap(nums, i++, j);
            }
            j++;
        }
        swap(nums, left, i - 1);
        return i - 1;
    }

    private void randomSelect(int[] nums, int left, int right) {
        int index = (int) (left + Math.random() * (right - left + 1));
        swap(nums, left, index);
    }

    private void swap(int[] nums, int i, int j) {
        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
    }
}
