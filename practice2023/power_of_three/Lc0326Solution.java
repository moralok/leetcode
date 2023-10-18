package practice2023.power_of_three;

public class Lc0326Solution {

    public boolean isPowerOfThree(int n) {
        if (n <= 0)  {
            return false;
        }
        while (n % 3 == 0) {
            n /= 3;
        }
        return n == 1;
    }
}
