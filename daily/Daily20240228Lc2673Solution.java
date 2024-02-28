package daily;

public class Daily20240228Lc2673Solution {

    public int minIncrements(int n, int[] cost) {
        int ans = 0;
        for (int i = n - 2; i > 0; i -= 2) {
            ans += Math.abs(cost[i] - cost[i + 1]);
            // 叶节点 i 和 i+1 的双亲节点下标为 i/2（整数除法）
            cost[i / 2] += Math.max(cost[i], cost[i + 1]);
        }
        return ans;
    }

    public int minIncrements1(int n, int[] cost) {
        return dfs(1, n , cost);
    }

    private int dfs(int i, int n, int[] cost) {
        if (i > n) {
            return 0;
        }
        int left = dfs(i * 2, n, cost);
        int right = dfs(i * 2 + 1, n, cost);
        int leftSum, rightSum;
        if (i * 2 > n) {
            leftSum = 0;
        } else {
            leftSum = cost[i * 2 - 1];
        }
        if (i * 2 + 1 > n) {
            rightSum = 0;
        } else {
            rightSum = cost[i * 2];
        }
        cost[i - 1] = cost[i - 1] + Math.max(leftSum, rightSum);
        return Math.abs(leftSum - rightSum) + left + right;
    }

    public static void main(String[] args) {
        Daily20240228Lc2673Solution solution = new Daily20240228Lc2673Solution();
        solution.minIncrements(15, new int[] {764,1460,2664,764,2725,4556,5305,8829,5064,5929,7660,6321,4830,7055,3761});
    }
}
