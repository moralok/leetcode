package dynamic_programming.range_sum_query_immutable;

class RangeSumQueryImmutable {

    private int[] nums;

    public RangeSumQueryImmutable(int[] nums) {
        this.nums = nums;
    }
    
    public int sumRange(int i, int j) {
        int res = 0;
        for (int k = i; k <= j; k++) {
            res += nums[k];
        }
        return res;
    }
}