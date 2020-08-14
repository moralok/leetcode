package lcof.lcof063;

public class Lcof063Solution {
    public int maxProfit(int[] prices) {
        if (prices.length < 2) {
            return 0;
        }
        int min = Integer.MAX_VALUE, max = Integer.MIN_VALUE, res = -1;
        for (int price : prices) {
            if (price > max) {
                max = price;
            }
            if (price < min) {
                min = price;
                max = min;
            }
            res = Math.max(res, max - min);
        }
        return res;
    }
}