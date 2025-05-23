package LeetCode.Leet300_399.Leet340_349.Leet343;

/**
 * @ClassName Solution_2
 * @Author 孙天赐
 * @Date 2025/5/21 16:55
 * @Description TODO: 方法二   动态规划    0ms 100%
 * 与方法一思路一致，不过更好理解
 */
class Solution_2 {
    public int integerBreak(int n) {
        //dp[i] 为正整数 i 拆分后的结果的最大乘积
        int[] dp = new int[n + 1];
        dp[2] = 1;
        for (int i = 3; i <= n; i++) {
            // 只需要遍历到 i/2 即可，因为后面的数会重复前面的数
            // 因为拆分一个数n 使之乘积最大，那么一定是拆分成m个近似相同的子数相乘才是最大的
            for (int j = 1; j <= i / 2; j++) {
                // 这里的 j 其实最大值为 i / 2,再大只不过是重复而已，
                // 并且，在本题中，我们分析 dp[0], dp[1]都是无意义的，
                // j 最大到 i / 2,就不会用到 dp[0]与dp[1]
                dp[i] = Math.max(dp[i], Math.max(j * (i - j), j * dp[i - j]));
                // j * (i - j) 是单纯的把整数 i 拆分为两个数 也就是 i,i-j ，再相乘
                // 而j * dp[i - j]是将 i 拆分成两个以及两个以上的个数,再相乘。
            }
        }
        return dp[n];
    }
}