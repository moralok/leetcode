package array.majority_element;

public class Solution3 {
    public int majorityElement(int[] nums) {
        int count = 0;
        int candidate = 0;
        for (int i = 0; i < nums.length; i++) {
            if (count == 0) {
                candidate = nums[i];
            }
            count += (candidate == nums[i]) ? 1 : -1;
        }
        return candidate;
    }

    public static void main(String[] args) {
        Solution3 solution = new Solution3();
        int[] case1 = new int[] {3,2,3};
        System.out.println(solution.majorityElement(case1));
        int[] case2 = new int[] {2,2,1,1,1,2,2};
        System.out.println(solution.majorityElement(case2));
    }
}