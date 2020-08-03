package lcof.lcof004;

public class Lcof004Solution {
    public boolean findNumberIn2DArray(int[][] matrix, int target) {
        // 暴力遍历就算了
        // O(N + M) O(1)
        // 两次二分法查找的思路并不正确！！！题解的证明描述好通俗易懂
        // 如果当前元素大于目标值，说明当前元素的下边的所有元素都一定大于目标值，因此往下查找不可能找到目标值，往左查找可能找到目标值。
        // 如果当前元素小于目标值，说明当前元素的左边的所有元素都一定小于目标值，因此往左查找不可能找到目标值，往下查找可能找到目标值。
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
            return false;
        }
        int rows = matrix.length, columns = matrix[0].length;
        int row = 0, column = columns - 1;
        while (row < rows && column >= 0) {
            int tmp = matrix[row][column];
            if (tmp == target) {
                return true;
            } else if (tmp > target) {
                column--;
            } else {
                row++;
            }
        }
        return false;
    }
}