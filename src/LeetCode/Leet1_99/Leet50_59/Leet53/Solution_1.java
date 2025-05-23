package LeetCode.Leet1_99.Leet50_59.Leet53;

/**
 * @ClassName Solution_1
 * @Author 孙天赐
 * @Date 2025/5/11 9:35
 * @Description TODO: 方法一   贪心算法   1ms  100%
 *                  贪心算法：
 *                  1. 从左到右遍历数组，记录当前区间的和
 *                  2. 若当前区间和为负数，则从下一个位置开始重新记录区间和
 *                  3. 每次记录区间和时，更新全局最优解
 *                  4. 遍历结束后，返回全局最优解
 *                  如果数组全是负数或者答案为负数，这种方法也能找到最大的那个负数
 */
class Solution_1 {
    public int maxSubArray(int[] nums) {
        int result = Integer.MIN_VALUE;  // 记录全局最优解
        int count = 0;  // 记录局部最优解

        for (int i = 0; i < nums.length; i++) {
            // 记录区间和
            count += nums[i];
            // 更新全局最优解
            if (count > result) {
                result = count;
            }
            // 若当前区间和为负数，则从下一个位置开始重新记录区间和
            if (count < 0) {
                count = 0;
            }
        }
        return result;
    }
}
