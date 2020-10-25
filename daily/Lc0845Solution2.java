class Lc0845Solution2 {
    public int longestMountain(int[] A) {
        // 有些细节没注意
        int n = A.length;
        int res = 0;
        int left = 0;
        while (left + 2 < n) {
            // right 作为下坡的开端
            int right = left + 1;
            if (A[left] < A[left + 1]) {
                while (right + 1 < n && A[right] < A[right + 1]) {
                    right++;
                }
                if (right + 1 < n && A[right] > A[right + 1]) {
                    while (right + 1 < n && A[right] > A[right + 1]) {
                        right++;
                    }
                    res = Math.max(res, right - left + 1);
                } else {
                    // 可能水平
                    right++;
                }
            }
            left = right;
        }
        return res;
    }

    public static void main(String[] args) {
        int[] A = new int[] {2,1,4,7,3,2,5};
        Lc0845Solution2 solution = new Lc0845Solution2();
        solution.longestMountain(A);
    }
}