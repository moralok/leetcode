package top;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Lc0046Solution {
    
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> ret = new ArrayList<>();
        List<Integer> output = new ArrayList<>();
        for (int i : nums) {
            output.add(i);
        }
        backtrack(nums.length, ret, output, 0);
        return ret;
    }

    private void backtrack(int n, List<List<Integer>> ret, List<Integer> output, int first) {
        if (first == n-1) {
            ret.add(new ArrayList<>(output));
            return;
        }
        for (int i = first; i < n; i++) {
            Collections.swap(output, first, i);
            backtrack(n, ret, output, first+1);
            Collections.swap(output, first, i);
        }
    }
}
