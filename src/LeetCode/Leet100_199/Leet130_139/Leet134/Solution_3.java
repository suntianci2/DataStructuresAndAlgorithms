package LeetCode.Leet100_199.Leet130_139.Leet134;

/**
 * @ClassName Solution_3
 * @Author 孙天赐
 * @Date 2025/5/17 11:44
 * @Description TODO: 方法三   模拟  2ms 85.84%
 *                  情况一：如果gas的总和小于cost总和，那么无论从哪里出发，一定是跑不了一圈的
 *                  情况二：rest[i] = gas[i]-cost[i]为一天剩下的油，i从0开始计算累加到最后一站，如果累加没有出现负数，说明从0出发，油就没有断过，那么0就是起点。
 *                  情况三：如果累加的最小值是负数，汽车就要从非0节点出发，从后向前，看哪个节点能把这个负数填平，能把这个负数填平的节点就是出发节点。
 */
class Solution_3 {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        int minSum = 0;  // 最小剩余油量
        int carSum = 0;  // 油箱中剩余油量
        // 假设从0位置出发，记录哪个位置所需的油量最多，也就是说哪个位置剩余油量最少
        for (int i = 0; i < gas.length; i++) {
            carSum += (gas[i] - cost[i]);
            minSum = Math.min(minSum, carSum);
        }

        // 情况一  绕一圈的剩余油量小于0，则从任何位置开始都不行
        if (carSum < 0) {
            return -1;
        }

        // 情况二  如果上面假设的从0开始，走到最后最小剩余油量大于等于0，则从0开始即可走完
        if (minSum >= 0) {
            return 0;
        }

        // 情况三  如果上面假设的从0开始，走到最后最小剩余油量小于0，说明某个或某些位置无法到达，则从后往前找能够使得最小剩余油量大于等于0的出发位置
        int index = gas.length;
        while (minSum < 0) {
            index--;
            minSum += (gas[index] - cost[index]);

        }
        return index;
    }
}
