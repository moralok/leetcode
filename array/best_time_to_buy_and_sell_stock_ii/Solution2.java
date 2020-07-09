package array.best_time_to_buy_and_sell_stock_ii;

public class Solution2 {

    public int maxProfit(int[] prices) {
        int i = 0;
        int valley = prices[0];
        int peak = prices[0];
        int maxprofit = 0;
        while (i < prices.length - 1) {
            while (i < prices.length - 1 && prices[i] >= prices[i + 1])
                i++;
            valley = prices[i];
            while (i < prices.length - 1 && prices[i] <= prices[i + 1])
                i++;
            peak = prices[i];
            maxprofit += peak - valley;
        }
        return maxprofit;
    }

    public static void main(String[] args) {
        int[] case1 = new int[] {7,1,5,3,6,4};
        int[] case2 = new int[] {1,2,3,4,5};
        int[] case3 = new int[] {7,6,4,3,1};
        Solution2 solution = new Solution2();
        System.out.println(solution.maxProfit(case1));
        System.out.println(solution.maxProfit(case2));
        System.out.println(solution.maxProfit(case3));
    }
}