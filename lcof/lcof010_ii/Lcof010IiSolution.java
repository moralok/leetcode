package lcof.lcof010_ii;

public class Lcof010IiSolution {

    public int numWays(int n) {
        // 视为类斐波那契数列，动态规划
        int a = 1, b = 1, sum = 0;
        while (n-- >= 1) {
            sum = (a + b) % 1000000007;
            a = b;
            b = sum;
        }
        return a;
    }
}