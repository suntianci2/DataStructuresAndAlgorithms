package LeetCode.Leet700_799.Leet740_749.Leet746;

/**
 * @ClassName Solution_2
 * @Author 孙天赐
 * @Date 2025/5/16 12:26
 * @Description TODO: 方法一    动态规划    0ms 100%
 *                  方法一的优化版
 */
class Solution_2 {
    public int minCostClimbingStairs(int[] cost) {
        int prePresStepMoney = 0;
        int preStepMoney = 0;
        int thisStepMoney = 0;
        for (int i = 2; i <= cost.length; i++) {
            // 到达第i个台阶的最低花费，为min(到第i-2个台阶的最小花费+i-2花费，到第i-1个台阶的最小花费+i-1花费)
            thisStepMoney = Math.min(prePresStepMoney + cost[i - 2], preStepMoney + cost[i - 1]);
            // 更新第i-2个台阶和第i-1个台阶的最小花费，用于下次循环
            prePresStepMoney = preStepMoney;
            preStepMoney = thisStepMoney;
        }
        return thisStepMoney;
    }
}
