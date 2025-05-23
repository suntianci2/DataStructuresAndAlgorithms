package LeetCode.Leet1_99.Leet60_69.Leet63;

/**
 * @ClassName Solution_1
 * @Author 孙天赐
 * @Date 2025/5/19 9:29
 * @Description TODO: 方法一    动态规划   0ms 100%
 * 第一行第一列障碍物及其后面均为0，其他位置为1
 * 其他行和列，障碍物处为0，非障碍物处为左边和上面的和
 */
class Solution {
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int m = obstacleGrid.length;
        int n = obstacleGrid[0].length;
        // dp[i][j] 表示从左上角到位置(i, j)的不同路径的数量
        int[][] dp = new int[m][n];
        // 初始化第一行和第一列（若遇到障碍，则障碍后面均为0）
        int i = 0;
        int j = 0;
        // 第一行
        while (j < n) {
            // 当前位置有障碍物，障碍物后均为0（初始化的时候默认为0，所以不需要再初始化）
            if (obstacleGrid[0][j] == 1) {
                break;
            }
            dp[0][j] = 1;
            j++;
        }
        // 第一列
        while (i < m) {
            // 当前位置有障碍物，障碍物后均为0（初始化的时候默认为0，所以不需要再初始化）
            if (obstacleGrid[i][0] == 1) {
                break;
            }
            dp[i][0] = 1;
            i++;
        }

        // 动态规划计算其他位置的路径数
        for (int x = 1; x < m; x++) {
            for (int y = 1; y < n; y++) {
                // 非障碍物处，可以通过在上面往下走一步，或左边往右走一步到达
                if (obstacleGrid[x][y] == 0) {
                    dp[x][y] = dp[x - 1][y] + dp[x][y - 1];
                }
                // 障碍物处dp为0，不需要操作
            }
        }
        return dp[m - 1][n - 1];
    }
}