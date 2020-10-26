package daily;

public class Lc1365Solution2 {
    
    public int[] smallerNumbersThanCurrent(int[] nums) {
        // 计数排序
        int n = nums.length;
        int[] bucket = new int[102];
        for (int i = 0; i < n; i++) {
            bucket[nums[i] + 1] += 1;
        }
        for (int i = 1; i < bucket.length; i++) {
            bucket[i] = bucket[i-1] + bucket[i];
        }
        int[] ret = new int[n];
        for (int i = 0; i < n; i++) {
            ret[i] = bucket[nums[i]];
        }
        return ret;
    }
}
