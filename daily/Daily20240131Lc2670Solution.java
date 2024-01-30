package daily;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class Daily20240131Lc2670Solution {

    public int[] distinctDifferenceArray(int[] nums) {
        int len = nums.length;
        Map<Integer, Integer> map = new HashMap<>();
        for (int num : nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }

        int[] res = new int[len];

        Map<Integer, Integer> leftMap = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            int num = nums[i];
            leftMap.put(num, leftMap.getOrDefault(num, 0) + 1);
            int rightCount = map.get(num) - 1;
            if (rightCount == 0) {
                map.remove(num);
            } else {
                map.put(num, rightCount);
            }
            res[i] = leftMap.size() - map.size();
        }
        return res;
    }

    public static void main(String[] args) {
        Daily20240131Lc2670Solution solution = new Daily20240131Lc2670Solution();
        int[] nums = new int[] {1,2,3,4,5};

        assert Arrays.equals(solution.distinctDifferenceArray(nums), new int[] {-3,-1,1,3,5});
    }
}
