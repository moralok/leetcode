package daily;

public class Lc2719Solution {

    // 暴力超时
    public int count(String num1, String num2, int min_sum, int max_sum) {
        long start = Long.parseLong(num1);
        long end = Long.parseLong(num2);
        long count = 0;
        for (long i = start; i <= end; i++) {
            int digitNum = digitNum(i);
            if (digitNum >= min_sum && digitNum <= max_sum) {
                count++;
            }
        }
        return (int) (count % (10^9 + 7));
    }

    private int digitNum(long x) {
        int ret = 0;
        while (x != 0) {
            ret += x % 10;
            x /= 10;
        }
        return ret;
    }

    public static void main(String[] args) {
        Lc2719Solution solution = new Lc2719Solution();
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
