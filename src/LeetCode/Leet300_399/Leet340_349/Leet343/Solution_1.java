package LeetCode.Leet300_399.Leet340_349.Leet343;

/**
 * @ClassName Solution_1
 * @Author 孙天赐
 * @Date 2025/5/21 16:37
 * @Description TODO: 方法一   动态规划    0ms 100%
 */
class Solution_1 {
    public int integerBreak(int n) {
        // n <= 3时，答案小于n，直接返回
        if (n == 2) {
            return 1;
        }
        if (n == 3) {
            return 2;
        }
        // 含义: dp[i]表示整数i可以获得的最大乘积（包括自身i！）
        int[] dp = new int[n + 1];
        dp[0] = 0;
        dp[1] = 1;
        // dp[2] = 2，实际上最大乘积为1，但是2本身不一定必须要拆，可以直接供后续计算
        // dp[3] = 3，实际上最大乘积为2，但是3本身不一定必须要拆，可以直接供后续计算
        // 当 n >= 4 时，答案一定大于等于n，可以在数学层面证明，所以 n >= 4的答案可以通过此动态规划寻找
        // 动态规划寻找后续最优解
        for (int i = 2; i <= n; i++) {
            // 寻找最大值
            int max = Integer.MIN_VALUE;
            // 找到(i - j) * dp[j]和i的最大值，即为当前位置的最优解
            for (int j = i - 1; j > 0; j--) {
                int temp = (i - j) * dp[j];
                max = temp > max ? temp : max;
            }
            dp[i] = max > i ? max : i;
        }
        return dp[n];
    }
}
