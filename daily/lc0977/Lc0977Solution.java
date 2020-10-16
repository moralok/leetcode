package daily.lc0977;

public class Lc0977Solution {
    public int[] sortedSquares(int[] A) {
        int len = A.length;
        int[] res = new int[len];
        int i = -1, j = 0;
        // 我好傻，找分界线为什么用两个指针！！！从0开始，negative就更新索引
        // 我透！！！反向从最大的开始就好了
        while (j < len) {
            if (A[j] >= 0) {
                break;
            } else {
                i++;
                j++;
            }
        }
        for (int k = 0; k < len; k++) {
            if (i < 0) {
                res[k] = A[j] * A[j];
                j++;
            } else if (j >= len) {
                res[k] = A[i] * A[i];
                i--;
            } else {
                int i2 = A[i] * A[i];
                int j2 = A[j] * A[j];
                if (i2 < j2) {
                    res[k] = i2;
                    i--;
                } else {
                    res[k] = j2;
                    j++;
                }
            }
        }
        return res;
    }
}
