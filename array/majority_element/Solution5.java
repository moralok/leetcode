package array.majority_element;

public class Solution5 {
    public int majorityElement(int[] nums) {
        return majorityElement(nums, 0, nums.length - 1);
    }

    private int majorityElement(int[] nums, int lo, int hi) {
        if (lo == hi) {
            return nums[lo];
        }
        int mid = (lo + hi) >> 1;
        int leftMajorityElement = majorityElement(nums, lo, mid);
        int rightMajorityElement = majorityElement(nums, mid + 1, hi);
        if (leftMajorityElement == rightMajorityElement) {
            return leftMajorityElement;
        }
        int leftCount = countInRange(nums, leftMajorityElement, lo, hi);
        int rightCount = countInRange(nums, rightMajorityElement, lo, hi);
        return leftCount > rightCount ? leftMajorityElement : rightMajorityElement;
    }

    private int countInRange(int[] nums, int num, int lo, int hi) {
        int count = 0;
        for (int i : nums) {
            if (i == num) {
                count++;
            }
        }
        return count;
    }

    public static void main(String[] args) {
        Solution5 solution = new Solution5();
        int[] case1 = new int[] {3,2,3};
        System.out.println(solution.majorityElement(case1));
        int[] case2 = new int[] {2,2,1,1,1,2,2};
        System.out.println(solution.majorityElement(case2));
    }
}