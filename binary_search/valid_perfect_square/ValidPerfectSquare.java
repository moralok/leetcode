package binary_search.valid_perfect_square;

public class ValidPerfectSquare {
    public boolean isPerfectSquare(int num) {
        // 二分法、牛顿-弗拉逊法
        long lo = 0, hi = num;
        while (lo <= hi) {
            long mid = lo + (hi - lo) / 2;
            long square = mid * mid;
            if (square == num) {
                return true;
            } else if (square > num) {
                hi = mid - 1;
            } else {
                lo = mid + 1;
            }
        }
        return false;
    }
}