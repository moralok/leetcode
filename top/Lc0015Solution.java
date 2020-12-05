package top;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Lc0015Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        int n;
        if (nums == null || (n = nums.length) < 3) {
            return Collections.emptyList();
        }
        Arrays.sort(nums);
        List<List<Integer>> ret = new ArrayList<>();
        for (int i = 0; i < n-2; i++) {
            int a = nums[i];
            int j = i+1, k = n-1;
            if (i > 0 && nums[i] == nums[i-1]) {
                continue;
            }
            while (j < k) {
                // j = i+1时是可以相等的
                if (j > i + 1 && nums[j] == nums[j-1]) {
                    j++;
                    continue;
                }
                if (nums[j] + nums[k] < -a) {
                    j++;
                } else if (nums[j] + nums[k] > -a) {
                    k--;
                } else {
                    List<Integer> e = new ArrayList<>(3);
                    e.add(nums[i]);
                    e.add(nums[j]);
                    e.add(nums[k]);
                    ret.add(e);
                    j++;
                    k--;
                }
            }
        }
        return ret;
    }

    public static void main(String[] args) {
        Lc0015Solution solution = new Lc0015Solution();
        int[] nums = new int[] {-1, 0, 1, 2, -1, -4};
        solution.threeSum(nums);
    }
}
