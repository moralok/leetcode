package practice2023.power_of_two;

public class Lc0231Solution {

    public boolean isPowerOfTwo(int n) {
        // 一眼想到常规解法的时候怎么还会往这方向思考呢
        return n > 0 && n == (n & -n);
    }
}
