class NumArray {

    private int[] nums;

    public NumArray(int[] nums) {
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