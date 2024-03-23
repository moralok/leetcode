package daily;

public class Daily20240323Lc2549Solution {

    public int distinctIntegers(int n) {
        return n == 1 ? 1 : n - 1;
    }

    public static void main(String[] args) {
        Daily20240323Lc2549Solution solution = new Daily20240323Lc2549Solution();
        assert solution.distinctIntegers(1) == 1;
        assert solution.distinctIntegers(2) == 1;
        assert solution.distinctIntegers(3) == 2;
        assert solution.distinctIntegers(4) == 3;
        assert solution.distinctIntegers(5) == 4;
        assert solution.distinctIntegers(6) == 5;
        assert solution.distinctIntegers(7) == 6;
        assert solution.distinctIntegers(8) == 7;
        assert solution.distinctIntegers(9) == 8;
        assert solution.distinctIntegers(10) == 9;
    }
}
