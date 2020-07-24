package binary_search.guess_number_higher_or_lower;

public class GuessNumberHigherOrLower {
    public int guessNumber(int n) {
        int lo = 1, hi = n;
        while (lo <= hi) {
            int mid = lo + (hi - lo) / 2;
            if (guess(mid) < 0) {
                hi = mid - 1;
            } else if (guess(mid) > 0) {
                lo = mid + 1;
            } else {
                return mid;
            }
        }
        return -1;
    }

    // 仅仅是为了避免语法错误
    private int guess(int i) {
        return 0;
    }
}