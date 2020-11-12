package daily;

public class Lc0922Solution {

    public int[] sortArrayByParityII(int[] A) {
        // 尽管对了，总觉得思路很傻，还不如重新开一个数组
        // 看了题解，思路一样都是人家写得好看
        int i = 0, j = 1;
        for (; i < A.length; i=i+2) {
            if (A[i] % 2 == 0) {
                continue;
            }
            for (; j < A.length; j=j+2) {
                if (A[j] % 2 == 1) {
                    continue;
                }
                swap(A, i, j);
                break;
            }
        }
        return A;
    }

    private void swap(int[] A, int i, int j) {
        int tmp = A[i];
        A[i] = A[j];
        A[j] = tmp;
    }
}