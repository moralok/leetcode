package daily;

import java.util.HashMap;
import java.util.Map;

public class Lc0454Solution {
    public int fourSumCount(int[] A, int[] B, int[] C, int[] D) {
        Map<Integer, Integer> countAB = new HashMap<>();
        for (int i = 0; i < A.length; i++) {
            for (int j = 0; j < B.length; j++) {
                countAB.put(A[i] + B[j], countAB.getOrDefault(A[i] + B[j], 0) + 1);
            }
        }
        int ret = 0;
        for (int i = 0; i < C.length; i++) {
            for (int j = 0; j < D.length; j++) {
                if (countAB.containsKey(-C[i] - D[j])) {
                    ret += countAB.get(-C[i] - D[j]);
                }
            }
        }
        return ret;
    }
}
