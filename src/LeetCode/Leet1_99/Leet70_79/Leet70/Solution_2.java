package LeetCode.Leet1_99.Leet70_79.Leet70;

/**
 * @ClassName Solution_2
 * @Author 孙天赐
 * @Date 2025/5/15 14:46
 * @Description TODO: 方法二   动态规划    0ms 100%
 *                  动态规划  递推公式：dp[i] = dp[i - 1] + dp[i - 2]
 *                  意思为：如果想爬到第i级台阶，那么只能从第i-1级台阶爬一步到达，或者从第i-2级台阶爬两步到达
 *                  空间复杂度较高
 */
class Solution_2 {
    public int climbStairs(int n) {
        if (n <= 2) {
            return n;
        }
        int[] dp = new int[n];
        dp[0] = 1;
        dp[1] = 2;
        for (int i = 2; i < n; i++) {
            dp[i] = dp[i - 1] + dp[i - 2];
        }
        return dp[n - 1];

    }
}