package daily;

public class Daily20240328Lc1997Solution {

    public int firstDayBeenInAllRooms(int[] nextVisit) {
        long MOD = 1000000007;
        int n = nextVisit.length;
        int[] dp = new int[n];
        for (int i = 1; i < n; i++) {
            dp[i] = (int) ((2 * dp[i - 1] % MOD - dp[nextVisit[i - 1]] + 2 + MOD) % MOD);
        }
        return dp[n - 1];
    }

    public static void main(String[] args) {
        Daily20240328Lc1997Solution solution = new Daily20240328Lc1997Solution();
        int[] nextVisit = new int[]{0, 0};
        assert solution.firstDayBeenInAllRooms(nextVisit) == 2;
        nextVisit = new int[]{0, 0, 2};
        assert solution.firstDayBeenInAllRooms(nextVisit) == 6;
    }
}
