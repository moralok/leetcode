package dynamic_programming;

// 假设你有一个长度为 n 的数组，初始情况下所有的数字均为 0，你将会被给出 k​​​​​​​ 个更新的操作。

// 其中，每个操作会被表示为一个三元组：[startIndex, endIndex, inc]，你需要将子数组 A[startIndex ... endIndex]（包括 startIndex 和 endIndex）增加 inc。

// 请你返回 k 次操作后的数组。

// 示例:

// 输入: length = 5, updates = [[1,3,2],[2,4,3],[0,2,-2]]
// 输出: [-2,0,3,5,3]
// 解释:

// 初始状态:
// [0,0,0,0,0]

// 进行了操作 [1,3,2] 后的状态:
// [0,2,2,2,0]

// 进行了操作 [2,4,3] 后的状态:
// [0,2,5,5,3]

// 进行了操作 [0,2,-2] 后的状态:
// [-2,0,3,5,3]

// 来源：力扣（LeetCode）
// 链接：https://leetcode-cn.com/problems/range-addition
// 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
public class Lc0370Solution {
    public int[] getModifiedArray(int length, int[][] updates) {
        // 差分
        int[] arr = new int[length];
        for (int[] update : updates) {
            int start = update[0], end = update[1], val = update[2];
            arr[start] += val;
            if (end < length - 1) {
                arr[end + 1] -= val;
            }
        }
        for (int i = 1; i < arr.length; i++) {
            arr[i] += arr[i-1];
        }
        return arr;
    }
}
