package daily;

public class Lc0977Solution2 {
    public int[] sortedSquares(int[] A) {
        int len = A.length;
        int[] res = new int[len];
        for (int i = 0, j = len - 1, pos = len - 1; i <= j; pos--) {
            int i2 = A[i] * A[i];
            int j2 = A[j] * A[j];
            if (i2 > j2) {
                res[pos] = i2;
                i++;
            } else {
                res[pos] = j2;
                j--;
            }
        }
        return res;
    }
}
