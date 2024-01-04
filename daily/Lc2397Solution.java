package daily;

public class Lc2397Solution {

    public int maximumRows(int[][] matrix, int numSelect) {
        int m = matrix.length, n = matrix[0].length;
        int[] mask = new int[m];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                mask[i] += matrix[i][j] << (n - j - 1);
            }
        }
        int ret = 0, cur = 0, limit = (1 << n);
        // 获取 numSelect 个 1 组成的数这么暴力
        while (++cur < limit) {
            if (Integer.bitCount(cur) != numSelect) {
                continue;
            }
            int t = 0;
            for (int i = 0; i < m; i++) {
                if ((mask[i] & cur) == mask[i]) {
                    t++;
                }
            }
            ret = Math.max(ret, t);
        }
        return ret;
    }

    public static void main(String[] args) {
        Lc2397Solution solution = new Lc2397Solution();

        int[][] matrix = new int[][] {
                {0,0,0},
                {1,0,1},
                {0,1,1},
                {0,0,1}
        };
        int numSelect = 2;
        assert solution.maximumRows(matrix, numSelect) == 3;

        matrix = new int[][] {
                {1},
                {0}
        };
        numSelect = 1;
        assert solution.maximumRows(matrix, numSelect) == 2;
    }
}
