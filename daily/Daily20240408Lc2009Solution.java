package daily;

import java.util.*;

public class Daily20240408Lc2009Solution {

    public int minOperations(int[] nums) {
        int n = nums.length;
        Set<Integer> set = new HashSet<>();
        for (int num : nums) {
            set.add(num);
        }
        List<Integer> sortedUniqueNums = new ArrayList<>(set);
        Collections.sort(sortedUniqueNums);
        int res = n;
        int j = 0;
        for (int i = 0; i < sortedUniqueNums.size(); i++) {
            int left = sortedUniqueNums.get(i);
            int right = left + n - 1;
            while (j < sortedUniqueNums.size() && sortedUniqueNums.get(j) <= right) {
                res = Math.min(res, n - (j - i + 1));
                j++;
            }
        }
        return res;
    }
}
