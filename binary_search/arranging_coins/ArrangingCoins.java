package binary_search.arranging_coins;

public class ArrangingCoins {
    public int arrangeCoins(int n) {
        int lo = 1, hi = n;
        while (lo <= hi) {
            int mid = lo + (hi - lo) / 2;
            long sum = (mid + 1) * mid / 2;
            if (sum == n) {
                return mid;
            } else if (sum > n) {
                hi = mid - 1;
            } else {
                lo = mid + 1;
            }
        }
        return lo - 1;
    }
}