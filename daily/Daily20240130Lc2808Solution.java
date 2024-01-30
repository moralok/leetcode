package daily;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Daily20240130Lc2808Solution {

    public int minimumSeconds(List<Integer> nums) {
        int size = nums.size();
        int res = Integer.MAX_VALUE;
        Map<Integer, List<Integer>> map = new HashMap<>();
        for (int i = 0; i < nums.size(); i++) {
            map.computeIfAbsent(nums.get(i), k -> new ArrayList<>()).add(i);
        }

        for (List<Integer> pos : map.values()) {
            int max = pos.get(0) + size - pos.get(pos.size() - 1);
            for (int i = 1; i < pos.size(); i++) {
                max = Math.max(max, pos.get(i) - pos.get(i - 1));
            }
            res = Math.min(res, max / 2);
        }
        return res;
    }

    public static void main(String[] args) {
        Daily20240130Lc2808Solution solution = new Daily20240130Lc2808Solution();
        List<Integer> nums = new ArrayList<>();
        for (int i : new int[]{1, 2, 1, 2}) {
            nums.add(i);
        }
        assert solution.minimumSeconds(nums) == 1;
    }
}
