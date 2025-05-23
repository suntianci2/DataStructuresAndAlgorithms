package LeetCode.Leet1_99.Leet60_69.Leet62;

/**
 * @ClassName Solution_1
 * @Author 孙天赐
 * @Date 2025/5/17 13:02
 * @Description TODO: 方法一   动态规划    0ms 100%
 */
class Solution_1 {
    public int uniquePaths(int m, int n) {
        // 表示从(0, 0)出发，到(i, j) 有dp[i][j]条不同的路径
        int[][] dp = new int[m][n];
        // 第一行均为1
        for (int i = 0; i < n; i++) {
            dp[0][i] = 1;
        }
        // 第一列均为1
        for (int j = 0; j < m; j++) {
            dp[j][0] = 1;
        }
        // 其余位置通过动态规划求解
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                // 到(i, j)位置的路径数，为到(i-1, j)位置的路径数与到(i, j-1)位置的路径数之和
                dp[i][j] = dp[i - 1][j] + dp[i][j - 1];
            }
        }
        return dp[m - 1][n - 1];
    }
}
