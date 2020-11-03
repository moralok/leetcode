package daily;

public class Lc0941Solution {

    public boolean validMountainArray(int[] A) {
        int i = 0;
        while (i < A.length - 1 && A[i] < A[i + 1]) {
            i++;
        }
        // 关注最高点
        if (i == 0 || i == A.length - 1) {
            return false;
        }
        while (i < A.length - 1 && A[i] > A[i + 1]) {
            i++;
        }
        return i == A.length - 1;
    }
}