package LeetCode.Leet1_99.Leet70_79.Leet70;

/**
 * @ClassName Solution_3
 * @Author 孙天赐
 * @Date 2025/5/15 14:47
 * @Description TODO: 方法三   动态规划    0ms 100%
 *                  方法二的优化版，降低空间复杂度
 */
class Solution_3 {
    public int climbStairs(int n) {
        if (n <= 2) {
            return n;
        }
        int pre = 2;  // 爬到第n-1级台阶所拥有的不同方法，初始化的为第2级台阶
        int prePre = 1;  // 爬到第n-2级台阶所拥有的不同方法，初始化的为第1级台阶
        int result = 3;  // 爬到第n级台阶所拥有的不同方法，等于pre + prePre，初始化的为第3级台阶
        // 从第四级台阶开始
        for (int i = 4; i <= n; i++) {
            prePre = pre; // 更新n-2
            pre = result; // 更新n-1
            // dp[i] = dp[i - 1] + dp[i - 2]
            result = pre + prePre;  // 更新n
        }
        return result;
    }
}
