package top;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class Lc0001Solution {
    public int[] twoSum(int[] nums, int target) {
        // 马上想到的是哈希表（感觉完全不会去想暴力枚举了）
        // 时间复杂度O(n)，空间复杂度O(n)
        // 看到评论里这题是梦的起点，我也做了这题好几次了，每次还是会下意识地担忧是不是没想到什么细节
        Map<Integer, Integer> map = new HashMap<>();
        int[] res = new int[2];
        for (int i = 0; i < nums.length; i++) {
            int another = target - nums[i];
            if (map.containsKey(another)) {
                res[0] = map.get(another);
                res[1] = i;
                break;
            } else {
                map.put(nums[i], i);
            }
        }
        return res;
    }

    public static void main(String[] args) {
        Lc0001Solution solution = new Lc0001Solution();
        int[] nums = new int[] {2,7,11,15};
        int target = 9;
        System.out.println(Arrays.toString(solution.twoSum(nums, target)));
    }
}
