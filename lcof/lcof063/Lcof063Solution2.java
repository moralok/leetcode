package lcof.lcof063;

public class Lcof063Solution2 {
    public int maxProfit(int[] prices) {
        int cost = Integer.MAX_VALUE, profit = 0;
        for (int price : prices) {
            if (price < cost) {
                cost = price;
            }
            profit = Math.max(price - cost, profit);
        }
        return profit;
    }
}