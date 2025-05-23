package LeetCode.Leet100_199.Leet130_139.Leet134;

/**
 * @ClassName Solution_1
 * @Author 孙天赐
 * @Date 2025/5/17 10:46
 * @Description TODO: 方法一   模拟（暴力求解）    超时
 *                  寻找找到每一个可能的出发位置，模拟看能否环绕一圈
 */
class Solution_1 {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        int result = -1;
        for (int i = 0; i < gas.length; i++) {
            if (gas[i] < cost[i]) {
                continue;
            }
            // 找到了可以出发的位置
            int carGas = 0;  // 油箱里面的油
            int j = i;
            for (; j < i + cost.length; j++) {
                carGas += gas[j % gas.length];  // 加油
                // 先在油箱扣除去往下一个加油站的油
                carGas -= cost[j % gas.length];
                // 若邮箱容量小于0，则表明不能去往下一个加油站
                if (carGas < 0) {
                    break;
                }


            }
            // 如果最后车子到了出发位置，则说明当前出发点是答案
            if (j == i + cost.length && carGas >= 0) {
                result = i;
                break;
            }
        }
        return result;
    }
}