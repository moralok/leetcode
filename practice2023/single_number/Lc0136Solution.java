package practice2023.single_number;

public class Lc0136Solution {

    public int singleNumber(int[] nums) {
        int eor = 0;
        for (int i = 0; i < nums.length; i++) {
            eor ^= nums[i];
        }
        return eor;
    }
}
