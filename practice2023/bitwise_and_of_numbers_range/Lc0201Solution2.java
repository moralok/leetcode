package practice2023.bitwise_and_of_numbers_range;

public class Lc0201Solution2 {

    public int rangeBitwiseAnd(int left, int right) {
        // 范围太大，排除线性时间复杂度的解法
        int step = 0;
        while (left < right) {
            left >>= 1;
            right >>= 1;
            step++;
        }
        return right << step;
    }
}
