class Lc0845Solution {
    public int longestMountain(int[] A) {
        // 中心扩散效率差这么多吗
        int res = 0;
        int n = A.length;
        for (int i = 1; i < n - 1; i++) {
            int left = i, right = i;
            while (left > 0 && A[left - 1] < A[left]) {
                left--;
            }
            while (right < n - 1 && A[right] > A[right + 1]) {
                right++;
            }
            if (i == left || i == right) {
                continue;
            }
            res = Math.max(res, right - left + 1);
            i = right + 1;
        }
        return res;
    }

    public static void main(String[] args) {
        int[] A = new int[] {2,1,4,7,3,2,5};
        Lc0845Solution solution = new Lc0845Solution();
        solution.longestMountain(A);
    }
}