package top;

public class Lc0326Solution2 {
    public boolean isPowerOfThree(int n) {
        // 酷但是效率低
        return Integer.toString(n, 3).matches("^10*$");
    }
}
