package practice2023.power_of_two;

public class Lc0231Solution3 {

    public boolean isPowerOfTwo(int n) {
        return n > 0 && (n & (n - 1)) == 0;
    }
}
