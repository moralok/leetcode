package top;

public class Lc0378Solution2 {
    public int kthSmallest(int[][] matrix, int k) {
        int n = matrix.length;
        int left = matrix[0][0], right = matrix[n-1][n-1];
        while (left < right) {
            int mid = left + ((right - left) >> 1);
            if (check(matrix, mid, k, n)) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }
        return left;
    }

    private boolean check(int[][] matrix, int mid, int k, int n) {
        int i = n-1, j = 0;
        int num = 0;
        while (i >= 0 && j <= n-1) {
            if (matrix[i][j] <= mid) {
                num += (i+1);
                j++;
            } else {
                i--;
            }
        }
        return num >= k;
    }
}
