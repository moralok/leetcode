package array.majority_element;

import java.util.Random;

public class Solution4 {
    public int majorityElement(int[] nums) {
        Random random = new Random();
        int majorityCount = nums.length / 2;
        while (true) {
            int index = getRandomIndex(random, 0, nums.length);
            if (count(nums, nums[index]) > majorityCount) {
                return nums[index];
            }
        }
    }

    private int getRandomIndex(Random random, int min, int max) {
        return random.nextInt(max - min) + min;
    }

    private int count(int[] nums, int num) {
        int count = 0;
        for (int i : nums) {
            if (i == num) {
                count++;
            }
        }
        return count;
    }

    public static void main(String[] args) {
        Solution4 solution = new Solution4();
        int[] case1 = new int[] {3,2,3};
        System.out.println(solution.majorityElement(case1));
        int[] case2 = new int[] {2,2,1,1,1,2,2};
        System.out.println(solution.majorityElement(case2));
    }
}