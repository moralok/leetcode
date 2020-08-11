package lcof.lcof057_ii;

import java.util.ArrayList;
import java.util.List;

public class Lcof057IiSolution {
    
    public int[][] findContinuousSequence(int target) {
        // 滑动窗口法
        List<int[]> list = new ArrayList<>();
        for (int i = 1, j = 2; i < j; ) {
            int sum = (i + j) * (j - i + 1) / 2;
            if (sum == target) {
                int[] tmp = new int[j - i + 1];
                for (int k = i; k <= j; k++) {
                    tmp[k - i] = k;
                }
                list.add(tmp);
                // 别忘了
                i++;
            } else if (sum < target) {
                j++;
            } else {
                i++;
            }
        }
        // 为啥java老要返回 int[][]
        return list.toArray(new int[list.size()][]);
    }
}