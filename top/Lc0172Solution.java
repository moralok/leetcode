package top;

public class Lc0172Solution {
    public int trailingZeroes(int n) {
        // 计算因子5的个数
        int count = 0;
        while (n != 0) {
            n = n / 5;
            count += (n + 1) * n / 2;
        }
        return count;
    }
}
