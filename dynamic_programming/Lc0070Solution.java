package dynamic_programming;

public class Lc0070Solution {
    public int climbStairs(int n) {
        // 1. 转移方程：f(n) = f(n-1) + f(n-2)
        // 2. 边界条件：f(1) = 1, f(2) = 2, f(0) = 1
        // 又倒在了数学上。。万一考了怎么办
        int prePre = 0, pre = 1, now;
        for (int i = 0; i < n; i++) {
            now = prePre + pre;
            prePre = pre;
            pre = now;
        }
        return pre;
    }

    public static void main(String[] args) {
        Lc0070Solution solution = new Lc0070Solution();
        System.out.println(solution.climbStairs(0));
        System.out.println(solution.climbStairs(1));
        System.out.println(solution.climbStairs(2));
        System.out.println(solution.climbStairs(3));
    }
}
