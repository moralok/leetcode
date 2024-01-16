package daily;

import java.util.Arrays;

public class Lc2719Solution2 {

    public static final int MOD = 1_000_000_007;

    public int count(String num1, String num2, int minSum, int maxSum) {
        int res = (cal(num2, minSum, maxSum) - cal(num1, minSum, maxSum) + MOD);
        int sum = 0;
        for (char ch : num1.toCharArray()) {
            sum += (ch - '0');
        }
        if (minSum <= sum && sum <= maxSum) {
            res++;
        }
        return res % MOD;
    }

    private int cal(String num, int minNum, int maxNum) {
        int length = num.length();
        int maxSum = Math.min(maxNum, 9 * length);
        int[][] memo = new int[length][maxSum + 1];
        for (int[] row : memo) {
            Arrays.fill(row, -1);
        }
        return dfs(0, 0, true, memo, num.toCharArray(), minNum, maxNum);
    }

    private int dfs(int idx, int sum, boolean isLimit, int[][] memo, char[] chars, int minNum, int maxNum) {
        if (sum > maxNum) {
            return 0;
        }
        if (idx == chars.length) {
            return sum >= minNum ? 1 : 0;
        }
        if (!isLimit && memo[idx][sum] != -1) {
            return memo[idx][sum];
        }

        int up = isLimit ? chars[idx] - '0' : 9;
        int res = 0;
        for (int i = 0; i <= up; i++) {
            res = (res + dfs(idx + 1, sum + i, isLimit && i == up, memo, chars, minNum, maxNum)) % MOD;
        }
        if (!isLimit) {
            memo[idx][sum] = res;
        }
        return res;
    }

    public static void main(String[] args) {
        Lc2719Solution2 solution = new Lc2719Solution2();
        String num1;
        String num2;
        int min_sum;
        int max_sum;

        num1 = "1";
        num2 = "12";
        min_sum = 1;
        max_sum = 8;
        assert solution.count(num1, num2, min_sum, max_sum) == 11;

        num1 = "1";
        num2 = "5";
        min_sum = 1;
        max_sum = 5;
        assert solution.count(num1, num2, min_sum, max_sum) == 5;

        num1 = "4179205230";
        num2 = "7748704426";
        min_sum = 8;
        max_sum = 46;
        assert solution.count(num1, num2, min_sum, max_sum) == 883045899;
    }
}
