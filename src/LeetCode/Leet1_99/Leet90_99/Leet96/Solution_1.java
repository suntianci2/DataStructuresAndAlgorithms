package LeetCode.Leet1_99.Leet90_99.Leet96;

/**
 * @ClassName Solution_1
 * @Author 孙天赐
 * @Date 2025/5/23 9:04
 * @Description TODO: 方法一    动态规划 0ms    100%
 */
class Solution_1 {
    public int numTrees(int n) {
        // dp含义：dp[i]为i个节点组成且节点值从1到i互不相同的二叉搜索树的个数
        int[] dp = new int[n + 1];
        dp[1] = 1;
        for (int i = 2; i <= n; i++) {
            // 计算分别以1到i为根节点，每个可以组成多少个二叉搜索树，总和即为dp[i]
            for (int j = 1; j <= i; j++) {
                if (j == 1 || j == i) {
                    // 如果是以1或i为根节点，则能够组成的二叉搜索树数量就是i-1个节点能够组成的二叉搜索树数量
                    // 例：总节点为6，根节点为1的话，能够组成的二叉搜索树数量就是节点2~6能组成的数量，等价于1~5能组成的数量，也就是dp[5]
                    dp[i] += dp[i - 1];
                } else {
                    // 否则，就是大于该根节点值的节点数量能够组成的二叉搜索树数量(dp[i - j]) * 小于该根节点值的节点数量能够组成的二叉搜索树数量(dp[j - 1])
                    // 例：总节点为6，根节点为3的话，左侧节点为1、2，有dp[2]种组成方式右侧节点为4、5、6，有dp[3]种组成方式，总组成方式为dp[2] * dp[3]
                    dp[i] += (dp[i - j] * dp[j - 1]);
                }

            }
        }
        return dp[n];
    }
}
