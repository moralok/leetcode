package array.maximum_product_of_three_numbers;

public class Solution2 {

    public int maximumProduct(int[] nums) {
        int min1 = Integer.MAX_VALUE, min2 = Integer.MAX_VALUE;
        int max1 = Integer.MIN_VALUE, max2 = Integer.MIN_VALUE, max3 = Integer.MIN_VALUE;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] < min1) {
                min2 = min1;
                min1 = nums[i];
            } else if (nums[i] < min2) {
                min2 = nums[i];
            }
            if (nums[i] > max1) {
                max3 = max2;
                max2 = max1;
                max1 = nums[i];
            } else if (nums[i] > max2) {
                max3 = max2;
                max2 = nums[i];
            } else if (nums[i] > max3) {
                max3 = nums[i];
            }
        }
        return Math.max(min1 * min2 * max1, max3 * max2 * max1);
    }

    public static void main(String[] args) {
        int[] case1 = new int[] {1,2,3};
        int[] case2 = new int[] {1,2,3,4};
        Solution2 solution = new Solution2();
        System.out.println(solution.maximumProduct(case1));
        System.out.println(solution.maximumProduct(case2));
    }
}