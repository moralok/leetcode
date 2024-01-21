package daily;

import java.util.Arrays;

public class Lc0410Solution {

    public int splitArray(int[] nums, int k) {
        int n = nums.length;
        int[][] f = new int[n + 1][k + 1];
        for (int[] ints : f) {
            Arrays.fill(ints, Integer.MAX_VALUE);
        }

        int[] sub = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            sub[i] = sub[i - 1] + nums[i - 1];
        }

        f[0][0] = 0;
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= Math.min(i, k); j++) {
                for (int m = 0; m < i; m++) {
                    f[i][j] = Math.min(f[i][j], Math.max(f[m][j - 1], sub[i] - sub[m]));
                }
            }
        }
        return f[n][k];
    }

    public static void main(String[] args) {
        Lc0410Solution solution = new Lc0410Solution();
        int[] nums;
        int k;

        nums = new int[] {7,2,5,10,8};
        k = 2;
        assert solution.splitArray(nums, k) == 18;

        nums = new int[] {1,2,3,4,5};
        assert solution.splitArray(nums, k) == 9;

        nums = new int[] {1,4,4};
        k = 3;
        assert solution.splitArray(nums, k) == 4;
    }
}
