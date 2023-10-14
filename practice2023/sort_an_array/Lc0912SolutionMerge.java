package practice2023.sort_an_array;

public class Lc0912SolutionMerge {

    private static int[] aux;
    
    public int[] sortArray(int[] nums) {
        aux = new int[nums.length];
        sort(nums, 0, nums.length - 1);
        return nums;
    }

    private void sort(int[] nums, int left, int right) {
        if (left == right) {
            return;
        }
        int mid = left + (right - left) / 2;
        sort(nums, left, mid);
        sort(nums, mid + 1, right);
        merge(nums, left, mid, right);
    }

    private void merge(int[] nums, int left, int mid, int right) {
        if (nums[mid] < nums[mid + 1]) {
            return;
        }
        for (int i = left; i <= right; i++) {
            aux[i] = nums[i];
        }
        int i = left, j = mid + 1, k = left;
        while (i <= mid || j <= right) {
            if (i > mid) {
                nums[k++] = aux[j++];
            } else if (j > right) {
                nums[k++] = aux[i++];
            } else {
                nums[k++] = aux[i] <= aux[j] ? aux[i++] : aux[j++];
            }
        }
    }
}
