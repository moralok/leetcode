## 动态规划
|题号|题目|难度|在本目录|
|----|----|----|----|
|[0053](https://leetcode-cn.com/problems/maximum-subarray/)|最大子序和|简单|是|
|[0070](https://leetcode-cn.com/problems/climbing-stairs/)|爬楼梯|简单|是|
|[0072](https://leetcode-cn.com/problems/edit-distance/)|编辑距离|困难|是|
|0121|买卖股票的最佳时机|简单|否|
|[0064](https://leetcode-cn.com/problems/minimum-path-sum/)|最小路径和|中等|是|
|[0303](https://leetcode-cn.com/problems/range-sum-query-immutable/)|区域和检索 - 数组不可变|简单|是|
|[0300](https://leetcode-cn.com/problems/longest-increasing-subsequence/)|最长上升子序列|中等|是|
|[1143](https://leetcode-cn.com/problems/longest-common-subsequence/)|最长公共子序列|中等|是|
|[0560](https://leetcode-cn.com/problems/subarray-sum-equals-k/)|和为K的子数组|中等|是|
|[0437](https://leetcode-cn.com/problems/path-sum-iii/)|路径总和 III|中等|是|
|[0370](https://leetcode-cn.com/problems/range-addition/)|区间加法|中等|是|

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

#### 矩阵
1. 同样有单串中的两种情况，即转移时要考虑 O(1)O(1) 个小规模子问题，和转移时要考虑 O(n)O(n) 个子问题
    - 64. 最小路径和


### 前缀和

#### 求区间和
1. 如果查询次数很多，当新查询来时，此前的查询计算的中间结果很多是可以直接用的，新的查询不必重新枚举
    - 303. 区域和检索 - 数组不可变

#### 数据结构维护前缀和
1. 第一问：a_{0}, a_{1}, ..., a_{n-1}上有没有一个区间，其和为 target。
2. 第二问：a_{0}, a_{1}, ..., a_{n-1}上有多少个区间，其和为 target。
    - 560. 和为 K 的子数组
3. 第三问：a_{0}, a_{1}, ..., a_{n-1}上有没有一个区间，其和大于/小于 target。
    - 327. 区间和的个数
4. 第四问：一棵树上有没有某个路径，其和为 target。
    - 437. 路径总和 III

#### 运算推广

#### 差分
差分序列的好处是如果要对原序列的一个区间 [l, r] 上所有值加 val，原序列上要操作 r-l+1 次 (a[l .. r] + val)，在差分序列上只需要操作 2 次(b[l] + val, b[r+1] - val)。如果这种区间操作需要很多次，最后的查询只有一次的话，就非常适合在差分序列上操作。