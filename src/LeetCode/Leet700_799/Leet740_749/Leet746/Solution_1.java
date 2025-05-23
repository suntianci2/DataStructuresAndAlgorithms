package LeetCode.Leet700_799.Leet740_749.Leet746;

/**
 * @ClassName Solution_1
 * @Author 孙天赐
 * @Date 2025/5/16 12:26
 * @Description TODO: 方法一    动态规划    0ms 100%
 *                  空间复杂度较高
 */
class Solution_1 {
    public int minCostClimbingStairs(int[] cost) {
        // dp[i]为到第i个台阶的最小花费，若有n个台阶，则楼梯顶部为第n+1个台阶
        int[] dp = new int[cost.length + 1];
        dp[0] = 0;
        dp[1] = 0;
        for (int i = 2; i < dp.length; i++) {
            // 到达第i个台阶的最低花费，为min(到第i-2个台阶的最小花费+i-2花费，到第i-1个台阶的最小花费+i-1花费)
            dp[i] = Math.min(dp[i - 2] + cost[i - 2], dp[i - 1] + cost[i - 1]);
        }
        return dp[dp.length - 1];
    }
}
