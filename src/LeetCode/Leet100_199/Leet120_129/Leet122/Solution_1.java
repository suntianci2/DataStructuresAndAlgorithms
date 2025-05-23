package LeetCode.Leet100_199.Leet120_129.Leet122;

/**
 * @ClassName Solution_1
 * @Author 孙天赐
 * @Date 2025/5/13 9:57
 * @Description TODO: 方法一    贪心算法 0ms   100%
 */
class Solution_1 {
    public int maxProfit(int[] prices) {
        int result = 0;
        // 累加所有上涨的价格即为答案
        for (int i = 1; i < prices.length; i++) {
            if (prices[i] > prices[i - 1]) {
                result += prices[i] - prices[i - 1];
            }
        }
        return result;
    }
}