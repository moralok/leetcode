package daily;

import java.util.ArrayList;
import java.util.List;

public class Lc2861Solution {

    public int maxNumberOfAlloys(int n, int k, int budget, List<List<Integer>> composition, List<Integer> stock, List<Integer> cost) {
        int lo = 0, hi = 200_000_000;
        int res = 0;
        while (lo <= hi) {
            int mid = lo + (hi - lo) / 2;
            boolean valid = false;
            for (int i = 0; i < k; i++) {
                long total = 0;
                for (int j = 0; j < n; j++) {
                    total += Math.max((long) composition.get(i).get(j) * mid - stock.get(j), 0) * cost.get(j);
                }
                if (total <= budget) {
                    valid = true;
                    break;
                }
            }
            if (valid) {
                res = mid;
                lo = mid + 1;
            } else {
                hi = mid - 1;
            }
        }
        return res;
    }

    public static void main(String[] args) {
        Lc2861Solution solution = new Lc2861Solution();
        int n = 3, k = 2, budget = 15;
        List<List<Integer>> composition = new ArrayList<>();
        List<Integer> l1 = new ArrayList<>();
        l1.add(1);
        l1.add(1);
        l1.add(1);
        List<Integer> l2 = new ArrayList<>();
        l2.add(1);
        l2.add(1);
        l2.add(10);
        composition.add(l1);
        composition.add(l2);
        List<Integer> stock = new ArrayList<>();
        stock.add(0);
        stock.add(0);
        stock.add(0);
        List<Integer> cost = new ArrayList<>();
        cost.add(1);
        cost.add(2);
        cost.add(3);
        assert solution.maxNumberOfAlloys(n, k, budget, composition, stock, cost) == 2;
    }
}
