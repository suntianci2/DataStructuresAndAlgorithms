package LeetCode.Leet1_99.Leet60_69.Leet62;

/**
 * @ClassName Solution_1
 * @Author 孙天赐
 * @Date 2025/5/17 13:02
 * @Description TODO: 方法二   动态规划    0ms 100%
 *                  对方法一的优化，优化空间复杂度，用一个一维数组存放即可
 */
class Solution_2 {
    public int uniquePaths(int m, int n) {
        int[] dp = new int[n];
        // 均初始化为1
        for (int i = 0; i < n; i++) {
            dp[i] = 1;
        }
        // 通过动态规划求解
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                // 到(i, j)位置的路径数，为到(i-1, j)位置的路径数与到(i, j-1)位置的路径数之和
                // dp[j]最初存放的是到(i-1, j)位置的路径数，更新后存放的是到(i, j)位置的路径数
                // dp[j - 1]在上一轮更新过了，存放的是到(i, j-1)位置的路径数
                dp[j] = dp[j] + dp[j - 1];
            }
        }
        return dp[n - 1];
    }
}
