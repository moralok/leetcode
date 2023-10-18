package practice2023.power_of_two;

public class Lc0231Solution4 {

    private static final int BIT = 1 << 30;

    public boolean isPowerOfTwo(int n) {
        return n > 0 && BIT % n == 0;
    }
}
