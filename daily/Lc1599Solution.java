package daily;

public class Lc1599Solution {

    public int minOperationsMaxProfit(int[] customers, int boardingCost, int runningCost) {
        int curCustoms = 0;
        int curProfit = 0;
        int maxProfit = 0;
        int ret = -1;
        for (int i = 0; i < customers.length || curCustoms > 0; i++) {
            if (i < customers.length) {
                curCustoms += customers[i];
            }
            int boardingNum = Math.min(curCustoms, 4);
            curCustoms -= boardingNum;
            curProfit += (boardingNum * boardingCost - runningCost);
            if (curProfit > 0 && curProfit > maxProfit) {
                ret = i + 1;
                maxProfit = curProfit;
            }
        }
        return ret;
    }

    public static void main(String[] args) {
        Lc1599Solution solution = new Lc1599Solution();

        int[] customers = new int[] {8,3};
        int boardingCost = 5;
        int runningCost = 6;
        assert solution.minOperationsMaxProfit(customers, boardingCost, runningCost) == 3;

        customers = new int[] {10,9,6};
        boardingCost = 6;
        runningCost = 4;
        assert solution.minOperationsMaxProfit(customers, boardingCost, runningCost) == 7;

        customers = new int[] {3,4,0,5,1};
        boardingCost = 1;
        runningCost = 92;
        assert solution.minOperationsMaxProfit(customers, boardingCost, runningCost) == -1;

        customers = new int[] {10,10,6,4,7};
        boardingCost = 3;
        runningCost = 8;
        assert solution.minOperationsMaxProfit(customers, boardingCost, runningCost) == 9;
    }
}
