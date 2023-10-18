package practice2023.power_of_three;

public class Lc0326Solution2 {

    public boolean isPowerOfThree(int n) {
        if (n <= 0) {
            return false;
        }
        int limit = Integer.MAX_VALUE / 3;
        int max = 1;
        while (max <= limit) {
            max *= 3;
        }
        // return n > 0 && 1162261467 % n == 0;
        return max % n == 0;
    }
}
