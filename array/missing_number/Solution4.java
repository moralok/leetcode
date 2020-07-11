package array.missing_number;

public class Solution4 {

    public int missingNumber(int[] nums) {
        int missing = nums.length;
        for (int i = 0; i < nums.length; i++) {
            missing ^= i ^ nums[i];
        }
        return missing;
    }

    public static void main(String[] args) {
        int[] case1 = new int[] {3,0,1};
        int[] case2 = new int[] {9,6,4,2,3,5,7,0,1};
        Solution4 solution = new Solution4();
        System.out.println(solution.missingNumber(case1));
        System.out.println(solution.missingNumber(case2));
    }
}