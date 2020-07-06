package reservoir_sampling.random_pick_index;

import java.util.Random;

class Solution {

    private int[] nums;

    public Solution(int[] nums) {
        this.nums = nums;
    }
    
    public int pick(int target) {
        int count = 0;
        int res = -1;
        Random random = new Random();
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == target) {
                count++;
                int rand = random.nextInt(count) + 1;
                if (rand == count) {
                    res = i;
                }
            }
        }
        return res;
    }

    public static void main(String[] args) {
        int[] arr = new int[] {1, 2, 3, 3, 3};
        Solution solution = new Solution(arr);
        for (int i = 0; i < 10; i++) {
            System.out.println(solution.pick(3));
        }
    }
}

/**
 * Your Solution object will be instantiated and called as such:
 * Solution obj = new Solution(nums);
 * int param_1 = obj.pick(target);
 */