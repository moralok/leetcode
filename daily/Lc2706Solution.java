package daily;

public class Lc2706Solution {

    // × 新的元素可能比原先的两个更小
    // × 仅靠前两个元素下判断
    public int buyChoco(int[] prices, int money) {
        int min = Integer.MAX_VALUE, max = Integer.MAX_VALUE;
        for (int i = 0; i < prices.length; i++) {
            if (prices[i] <= min) {
                max = min;
                min = prices[i];
            } else if (prices[i] > min && prices[i] < max) {
                max = prices[i];
            }
        }
        int sum = min + max;
        if (sum > money) {
            return money;
        } else {
            return money - sum;
        }
    }

    public static void main(String[] args) {
        Lc2706Solution solution = new Lc2706Solution();
        int[] prices = new int[] {1,2,2};
        int money = 3;
        assert solution.buyChoco(prices, money) == 0;

        prices = new int[] {3,2,3};
        assert solution.buyChoco(prices, money) == 3;


        prices = new int[] {98,54,6,34,66,63,52,39};
        money = 62;
        assert solution.buyChoco(prices, money) == 22;
    }
}
