package lcof.lcof010_i;

public class Lcof010ISolution2 {
    public int fib(int n) {
        // 动态规划
        // 别忘记求余
        if (n == 0) {
            return 0;
        }
        if (n == 1) {
            return 1;
        }
        int a = 0, b = 1, sum = 0;
        while (n-- >= 2) {
            // 求余运算规则： 设正整数 x, y, p ，求余符号为 ⊙ ，则有 (x+y)⊙p=(x⊙p+y⊙p)⊙p 。
            sum = ((a % 1000000007) + (b % 1000000007)) % 1000000007;
            a = b;
            b = sum;
        }
        // 我去！大佬是return a 的，就不用特殊处理了
        return sum;
    }
}