package daily;

import java.util.Arrays;

public class Lc1365Solution {
    
    public int[] smallerNumbersThanCurrent(int[] nums) {
        // 先排序，后确定位置
        int n = nums.length;
        int[][] data = new int[n][2];
        for (int i = 0; i < n; i++) {
            data[i][0] = nums[i];
            data[i][1] = i;
        }
        Arrays.sort(data, (w, v) -> w[0] - v[0]);
        int[] ret = new int[n];
        int pre = -1;
        for (int i = 0; i < n; i++) {
            if (i == 0 || data[i][0] != data[i - 1][0]) {
                pre = i;
            }
            ret[data[i][1]] = pre;
        }
        return ret;
    }
}
