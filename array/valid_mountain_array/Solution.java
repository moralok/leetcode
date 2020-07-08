package array.valid_mountain_array;

public class Solution {

    public boolean validMountainArray(int[] A) {
        int n = A.length;
        int i = 0;
        
        while (i + 1 < n && A[i] < A[i + 1]) {
            i++;
        }

        if (i == 0 || i == n-1) {
            return false;
        }

        while (i + 1 < n && A[i] > A[i + 1]) {
            i++;
        }
        return i == n-1;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] case1 = new int[] {2,1};
        int[] case2 = new int[] {3,5,5};
        int[] case3 = new int[] {0,3,2,1};
        System.out.println(solution.validMountainArray(case1));
        System.out.println(solution.validMountainArray(case2));
        System.out.println(solution.validMountainArray(case3));
    }
}