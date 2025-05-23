package LeetCode.Leet1_99.Leet40_49.Leet45;

/**
 * @ClassName Solution_2
 * @Author 孙天赐
 * @Date 2025/5/15 9:12
 * @Description TODO: 方法二    动态规划（贪心）  1ms 99.54%
 *                  在当前步动态更新下一步可到达的最远距离，且下一步是从当前步可到达的最远距离的位置开始的，减少循环次数
 */
class Solution_2 {
    public int jump(int[] nums) {
        int result = 0;  // 最终要跳跃的次数
        int thisStep = 0;  // 当前步可到达的最远距离
        int nextStep = 0;  // 下一步可到达的最远距离
        for (int i = 0; i < nums.length; i++) {
            // 动态更新下一步可到达的最远距离
            nextStep = Math.max(nextStep, nums[i] + i);
            // 如果已经走到了当前步可到达的最远距离，且还没有到达终点，说明需要新增一步了
            if (i == thisStep && i != nums.length - 1) {
                result++;
                // 下一步变为当前步
                thisStep = nextStep;
                // 如果当前步可到达的最远距离超过了终点，则终止循环
                if (thisStep > nums.length - 1) {
                    break;
                }
            }
        }
        return result;
    }
}
