package lcof.lcof029;

public class Lcof029Solution {
    public int[] spiralOrder(int[][] matrix) {
        // 简单的思路写得这么漂亮，厉害
        if (matrix == null || matrix.length == 0) {
            return new int[0];
        }
        int l = 0, r = matrix[0].length - 1, t = 0, b = matrix.length - 1;
        int[] res = new int[(r + 1) * (b + 1)];
        int idx = 0;
        while (true) {
            for (int i = l; i <= r; i++) {
                res[idx++] = matrix[t][i];
            }
            if (++t > b) {
                break;
            }
            for (int i = t; i <= b; i++) {
                res[idx++] = matrix[i][r];
            }
            if (--r < l) {
                break;
            }
            for (int i = r; i >= l; i--) {
                res[idx++] = matrix[b][i];
            }
            if (--b < t) {
                break;
            }
            for (int i = b; i >= t; i--) {
                res[idx++] = matrix[i][l];
            }
            if (++l > r) {
                break;
            }
        }
        return res;
    }
}