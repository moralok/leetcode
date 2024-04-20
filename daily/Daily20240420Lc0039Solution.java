package daily;

import java.util.ArrayList;
import java.util.List;

public class Daily20240420Lc0039Solution {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> combine = new ArrayList<>();
        dfs(candidates, target, res, combine, 0);
        return res;
    }

    private void dfs(int[] candidates, int target, List<List<Integer>> res, List<Integer> combine, int idx) {
        if (idx == candidates.length) {
            return;
        }
        if (target == 0) {
            res.add(new ArrayList<>(combine));
            return;
        }
        dfs(candidates, target, res, combine, idx + 1);
        if (target - candidates[idx] >= 0) {
            combine.add(candidates[idx]);
            dfs(candidates, target - candidates[idx], res, combine, idx);
            combine.remove(combine.size() - 1);
        }
    }

    public static void main(String[] args) {
        Daily20240420Lc0039Solution solution = new Daily20240420Lc0039Solution();
        int[] candidates = {2, 3, 6, 7};
        int target = 7;
        System.out.println(solution.combinationSum(candidates, target));
    }
}
