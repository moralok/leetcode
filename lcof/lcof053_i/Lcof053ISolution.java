package lcof.lcof053_i;

public class Lcof053ISolution {

    public int search(int[] nums, int target) {
        // 忽略排序，应该不行吧。。。
        int res = 0;
        for (int i : nums) {
            if (i == target) {
                res++;
            }
        }
        return res;
    }
}