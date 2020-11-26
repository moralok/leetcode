package daily;

import java.util.Arrays;

public class Lc0164Solution {
    public int maximumGap(int[] nums) {
        int n = nums.length;
        if (n < 2) {
            return 0;
        }
        int max = Arrays.stream(nums).max().getAsInt();
        int min = Arrays.stream(nums).min().getAsInt();
        int d = Math.max(1, (max - min) / (n - 1));
        int bucketSize = (max - min) / d + 1;
        int[][] bucket = new int[bucketSize][2];
        for (int i = 0; i < bucketSize; i++) {
            Arrays.fill(bucket[i], -1);
        }
        for (int i = 0; i < n; i++) {
            int idx = (nums[i] - min) / d;
            if (bucket[idx][0] == -1) {
                bucket[idx][0] = bucket[idx][1] = nums[i];
            } else {
                bucket[idx][0] = Math.min(bucket[idx][0], nums[i]);
                bucket[idx][1] = Math.max(bucket[idx][1], nums[i]);
            }
        }
        int ret = 0, pre = -1;
        for (int i = 0; i < bucket.length; i++) {
            if (bucket[i][0] == -1) {
                continue;
            }
            if (pre != -1) {
                ret = Math.max(ret, bucket[i][0] - bucket[pre][1]);
            }
            pre = i;
        }
        return ret;
    }
}
