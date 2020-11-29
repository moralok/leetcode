## 动态规划
|题号|题目|难度|在本目录|
|----|----|----|----|
|[0053](https://leetcode-cn.com/problems/maximum-subarray/)|最大子序和|简单|是｜
|[0070](https://leetcode-cn.com/problems/climbing-stairs/)|爬楼梯|简单|是|
|[0072](https://leetcode-cn.com/problems/edit-distance/)|编辑距离|困难|是|
|0121|买卖股票的最佳时机|简单|否｜
|0303|区域和检索 - 数组不可变|简单|
|[0300](https://leetcode-cn.com/problems/longest-increasing-subsequence/)|最长上升子序列|中等|是|
|[1143](https://leetcode-cn.com/problems/longest-common-subsequence/)|最长公共子序列|中等|是|

## 总结
用动态规划解决问题的过程有以下几个关键点：状态定义，状态的转移，初始化和边界条件。

### 线性动态规划

#### 单串
1. 依赖比 i 小的 O(1) 个子问题
    - 53. 最大子数组和
2. 依赖比 i 小的 O(n) 个子问题
    - 300. 最长上升子序列

#### 双串
1. 最常见的状态转移形式：推导 dp[i][j] 时，dp[i][j] 仅与 dp[i-1][j], dp[i][j-1], dp[i-1][j-1]
    - 1143. 最长公共子序列