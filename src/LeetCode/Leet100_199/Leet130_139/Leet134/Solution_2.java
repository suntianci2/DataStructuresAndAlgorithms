package LeetCode.Leet100_199.Leet130_139.Leet134;

/**
 * @ClassName Solution_2
 * @Author 孙天赐
 * @Date 2025/5/17 11:27
 * @Description TODO: 方法二   贪心算法    2ms 85.84%
 *                  贪心贪在：寻找第一个能够到数组最后的位置
 *                      若从startIndex出发，到i位置时，剩余油量小于0，则说明[startIndex, i]区间内任意位置都不能当作起点
 *                      startIndex更新为i+1，下一轮循环从i+1继续开始，油箱清空
 *                      若绕一圈的剩余油量小于0，则从任何位置开始都不行
 *                      若绕一圈的剩余油量大于等于0，则从startIndex开始一定可以绕一圈
 */
class Solution_2 {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        int startIndex = 0;
        int sum = 0;
        int totalSum = 0;
        for (int i = 0; i < gas.length; i++) {
            // 累加从startIndex到i区间内行驶的剩余油量（startIndex处油箱没有油）
            sum += (gas[i] - cost[i]);
            // 记录绕一圈的剩余油量
            totalSum += (gas[i] - cost[i]);
            // 若出现了剩余油量小于0的情况，说明[startIndex, i]区间内任意位置都不能当作起点，到i位置油都不够
            // 下一轮循环从i+1继续开始，油箱清空
            if (sum < 0) {
                startIndex = i + 1;
                sum = 0;
            }
        }
        // 绕一圈的剩余油量小于0，则从任何位置开始都不行
        if (totalSum < 0) {
            return -1;
        }
        return startIndex;
    }
}
