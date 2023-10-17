package practice2023.single_number_ii;

public class Lc0137Solution {

    public int singleNumber(int[] nums) {
        return singleNumber(nums, 3);
    }

    private int singleNumber(int[] nums, int m) {
        int[] counts= new int[32];
        for (int i = 0; i < nums.length; i++) {
            for (int j = 0; j < 32; j++) {
                counts[j] += nums[i] & 1;
                nums[i] >>>= 1;
            }
        }
        int ans = 0;
        for (int i = 0; i < 32; i++) {
            if (counts[i] % m != 0) {
                ans |= 1 << i;
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        int[] nums = new int[] {2,2,3,2};
        Lc0137Solution solution = new Lc0137Solution();
        int ans = solution.singleNumber(nums);
        System.out.println(ans);
    }
}
