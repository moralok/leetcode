package daily;

import java.util.Arrays;

public class Daily20240330Lc2952Solution {

    public int minimumAddedCoins(int[] coins, int target) {
        Arrays.sort(coins);
        int n = coins.length;
        int index = 0;
        int x = 1;
        int res = 0;
        while (x <= target) {
            if (index < n && coins[index] <= x) {
                x += coins[index];
                index++;
            } else {
                x *= 2;
                res++;
            }
        }
        return res;
    }

    public static void main(String[] args) {
        Daily20240330Lc2952Solution solution = new Daily20240330Lc2952Solution();
        assert solution.minimumAddedCoins(new int[]{1, 4, 10}, 19) == 2;
        assert solution.minimumAddedCoins(new int[]{1, 4, 10, 5, 7, 19}, 19) == 1;
        assert solution.minimumAddedCoins(new int[]{1, 1, 1}, 20) == 3;
    }
}
