package daily;

import java.util.Arrays;

public class Daily20240202Lc1686Solution {

    public int stoneGameVI(int[] aliceValues, int[] bobValues) {
        int n = aliceValues.length;
        int[][] sum = new int[n][3];
        for (int i = 0; i < n; i++) {
            sum[i][0] = aliceValues[i] + bobValues[i];
            sum[i][1] = aliceValues[i];
            sum[i][2] = bobValues[i];
        }
        Arrays.sort(sum, (a, b) -> b[0] - a[0]);
        int aliceSum = 0, bobSum = 0;
        int robin = 0;
        for (int i = 0; i < n; i++) {
            if (robin % 2 == 0) {
                aliceSum += sum[i][1];
            } else {
                bobSum += sum[i][2];
            }
            robin++;
        }
        return Integer.compare(aliceSum, bobSum);
    }

    public static void main(String[] args) {
        int[] aliceValues = new int[] {1,3};
        int[] bobValues = new int[] {2,1};
        Daily20240202Lc1686Solution solution = new Daily20240202Lc1686Solution();
        assert solution.stoneGameVI(aliceValues, bobValues) == 1;
    }
}
