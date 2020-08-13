package lcof.lcof045;

import java.util.Arrays;

public class Lcof045Solution {
    public String minNumber(int[] nums) {
        String[] strs = new String[nums.length];
        for (int i = 0; i < nums.length; i++) {
            strs[i] = String.valueOf(nums[i]);
        }
        Arrays.sort(strs, (x, y) -> (x + y).compareTo(y + x));
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < strs.length; i++) {
            // 喵喵喵？不是说要把前导0去除吗？我竟眼花了。。。
            sb.append(strs[i]);
        }
        return sb.toString();
    }
}