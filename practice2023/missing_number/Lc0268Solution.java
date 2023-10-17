package practice2023.missing_number;

public class Lc0268Solution {

    public int missingNumber(int[] nums) {
        int eorAll = 0;
        for (int i = 0; i < nums.length; i++) {
            eorAll ^= nums[i];
        }
        for (int i = 0; i <= nums.length; i++) {
            eorAll ^= i;
        }
        return eorAll;
    }
}
