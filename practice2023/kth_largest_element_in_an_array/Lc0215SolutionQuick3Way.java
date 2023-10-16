package practice2023.kth_largest_element_in_an_array;

public class Lc0215SolutionQuick3Way {

    public int findKthLargest(int[] nums, int k) {
        return findKthLargest(nums, k, 0, nums.length - 1);
    }

    private int findKthLargest(int[] nums, int k, int left, int right) {
        if (left == right) {
            return nums[left];
        }
        randomSelect(nums, left, right);

        int val = nums[left];
        int lt = left, gt = right, i = left + 1;
        while (i <= gt) {
            if (nums[i] < val) {
                swap(nums, i++, lt++);
            } else if (nums[i] == val) {
                i++;
            } else {
                swap(nums, i, gt--);
            }
        }

        if (gt < nums.length - k) {
            return findKthLargest(nums, k, gt + 1, right);
        } else if (lt > nums.length - k) {
            return findKthLargest(nums, k, left, lt - 1);
        } else {
            return nums[lt];
        }
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

    public static void main(String[] args) {
        int[] nums = new int[] {3,2,1,5,6,4};
        Lc0215SolutionQuick3Way lc0215SolutionQuick3Way = new Lc0215SolutionQuick3Way();
        int res = lc0215SolutionQuick3Way.findKthLargest(nums, 2);
        System.out.println(res);
    }
}
