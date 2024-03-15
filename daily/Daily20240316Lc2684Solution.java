package daily;

import java.util.HashSet;
import java.util.Set;

public class Daily20240316Lc2684Solution {

    public int maxMoves(int[][] grid) {
        int m = grid.length, n = grid[0].length;
        int[][] dp = new int[m][n];
        int max = 0;
        for (int j = 1; j < n; j++) {
            int tmp = 0;
            for (int i = 0; i < m; i++) {
                if (i != 0 && grid[i - 1][j - 1] < grid[i][j] && (j == 1 || dp[i - 1][j - 1] != 0)) {
                    dp[i][j] = Math.max(dp[i][j], dp[i - 1][j - 1] + 1);
                }
                if (grid[i][j - 1] < grid[i][j] && (j == 1 || dp[i][j - 1] != 0)) {
                    dp[i][j] = Math.max(dp[i][j], dp[i][j - 1] + 1);
                }
                if (i != m - 1 && grid[i + 1][j - 1] < grid[i][j] && (j == 1 || dp[i + 1][j - 1] != 0)) {
                    dp[i][j] = Math.max(dp[i][j], dp[i + 1][j - 1] + 1);
                }
                tmp = Math.max(tmp, dp[i][j]);
            }
            if (tmp == 0) {
                break;
            }
            max = Math.max(max, tmp);
        }
        return max;
    }

    public int maxMoves1(int[][] grid) {
        int m = grid.length, n = grid[0].length;
        Set<Integer> set = new HashSet<>();
        for (int i = 0; i < m; i++) {
            set.add(i);
        }
        for (int j = 1; j < n; j++) {
            Set<Integer> tmp = new HashSet<>();
            for (Integer node : set) {
                for (int i = node - 1; i <= node + 1; i++) {
                    if (i >= 0 && i < m && grid[node][j - 1] < grid[i][j]) {
                        tmp.add(i);
                    }
                }
            }
            set = tmp;
            if (tmp.isEmpty()) {
                return j - 1;
            }
        }
        return n - 1;
    }

    public static void main(String[] args) {
        Daily20240316Lc2684Solution solution = new Daily20240316Lc2684Solution();
        int[][] grip = new int[][]{{2, 4, 3, 5}, {5, 4, 9, 3}, {3, 4, 2, 11}, {10, 9, 13, 15}};
        assert solution.maxMoves(grip) == 3;
        assert solution.maxMoves1(grip) == 3;

        grip = new int[][]{{3, 2, 4}, {2, 1, 9}, {1, 1, 7}};
        assert solution.maxMoves(grip) == 0;

        grip = new int[][]{{187, 167, 209, 251, 152, 236, 263, 128, 135}, {267, 249, 251, 285, 73, 204, 70, 207, 74}, {189, 159, 235, 66, 84, 89, 153, 111, 189},
                {120, 81, 210, 7, 2, 231, 92, 128, 218}, {193, 131, 244, 293, 284, 175, 226, 205, 245}};
        assert solution.maxMoves(grip) == 3;

        grip = new int[][]{{65,200,263,220,91,183,2,187,175,61,225,120,39},{111,242,294,31,241,90,145,25,262,214,145,71,294},
        {152,25,240,69,279,238,222,9,137,277,8,143,143},{189,31,86,250,20,63,188,209,75,22,127,272,110},{122,94,298,25,90,169,68,3,208,274,202,135,275},
        {205,20,171,90,70,272,280,138,142,151,80,122,130},{284,272,271,269,265,134,185,243,247,50,283,20,232},{266,236,265,234,249,62,98,130,122,226,285,168,204},
        {231,24,256,101,142,28,268,82,111,63,115,13,144},{277,277,31,144,49,132,28,138,133,29,286,45,93},{163,96,25,9,3,159,148,59,25,81,233,127,12},
        {127,38,31,209,300,256,15,43,74,64,73,141,200}};
        assert solution.maxMoves(grip) == 3;
    }
}
