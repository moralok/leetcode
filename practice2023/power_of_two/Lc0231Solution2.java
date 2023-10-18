package practice2023.power_of_two;

public class Lc0231Solution2 {

    public boolean isPowerOfTwo(int n) {
        if (n <= 0) {
            return false;
        }
        while (n % 2 == 0) {
            n /= 2;
        }
        return n / 2 == 0;
    }
}
