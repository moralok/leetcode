package practice2023.bitwise_and_of_numbers_range;

public class Lc0201Solution {

    // 找到二进制字符串的公共前缀
    public int rangeBitwiseAnd(int left, int right) {
        // 范围太大，排除线性时间复杂度的解法
        while (left < right) {
            right -= (right & -right);
        }
        return right;
    }
}
