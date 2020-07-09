package array.best_time_to_buy_and_sell_stock_ii;

public class Solution {

    public int maxProfit(int[] prices) {
        int maxprofit = 0;
        for (int i = 1; i < prices.length; i++) {
            if (prices[i] > prices[i - 1])
                maxprofit += prices[i] - prices[i - 1];
        }
        return maxprofit;
    }

    public static void main(String[] args) {
        int[] case1 = new int[] {7,1,5,3,6,4};
        int[] case2 = new int[] {1,2,3,4,5};
        int[] case3 = new int[] {7,6,4,3,1};
        Solution solution = new Solution();
        System.out.println(solution.maxProfit(case1));
        System.out.println(solution.maxProfit(case2));
        System.out.println(solution.maxProfit(case3));
    }
}