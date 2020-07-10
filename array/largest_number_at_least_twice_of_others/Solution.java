package array.largest_number_at_least_twice_of_others;

public class Solution {
    public int dominantIndex(int[] nums) {
        // 注意1: when nums.length == 1, return 0
        // 注意2: preMax除了更新最大值时，在遇到小于最大值大于次最大值时也需要更新 
        int preMax = 0;
        int max = 0;
        int idx = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] > max) {
                preMax = max;
                max = nums[i];
                idx = i;
            } else if (nums[i] > preMax) {
                preMax = nums[i];
            }
        }
        if ((max / 2) >= preMax) {
            return idx;
        }
        return - 1;
    }

    public static void main(String[] args) {
        int[] case1 = new int[] {3, 6, 1, 0};
        int[] case2 = new int[] {1, 2, 3, 4};
        int[] case3 = new int[] {1};
        int[] case4 = new int[] {0,0,3,2};
        Solution solution = new Solution();
        System.out.println(solution.dominantIndex(case1));
        System.out.println(solution.dominantIndex(case2));
        System.out.println(solution.dominantIndex(case3));
        System.out.println(solution.dominantIndex(case4));
    }
    
}