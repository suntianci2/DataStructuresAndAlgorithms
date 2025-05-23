package LeetCode.Leet1_99.Leet90_99.Leet96;

/**
 * @ClassName Solution_2
 * @Author 孙天赐
 * @Date 2025/5/23 9:19
 * @Description TODO: 方法二    动态规划 0ms    100%
 *                  对方法一的优化，初始化dp[0] = 1，这样就可以把j == 1 || j == i的情况合并
 *
 */
class Solution_2 {
    public int numTrees(int n) {
        // dp含义：dp[i]为i个节点组成且节点值从1到i互不相同的二叉搜索树的个数
        int[] dp = new int[n + 1];
        dp[0] = 1;
        for(int i = 1;i <= n;i++){
            // 计算分别以1到i为根节点，每个可以组成多少个二叉搜索树，总和即为dp[i]
            for(int j = 1;j <= i;j++){
                // 对于第i个节点，需要考虑1作为根节点直到i作为根节点的情况，所以需要累加
                // 一共i个节点，对于根节点j时,左子树的节点个数为j-1，右子树的节点个数为i-j
                dp[i] += (dp[i - j] * dp[j - 1]);
            }
        }
        return dp[n];
    }
}
