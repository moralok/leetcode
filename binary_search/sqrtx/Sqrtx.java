package binary_search.sqrtx;

public class Sqrtx {
    public int mySqrt(int x) {
        // 二分法查找
        int l = 0, r = x, ans = -1;
        while (l <= r) {
            int mid = (l + r) >> 1;
            if ((long)mid * mid <= x) {
                ans = mid;
                l = mid + 1;
            } else {
                r = mid - 1;
            }
        }
        return ans;
    }
}