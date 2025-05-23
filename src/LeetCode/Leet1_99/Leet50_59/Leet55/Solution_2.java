package LeetCode.Leet1_99.Leet50_59.Leet55;

/**
 * @ClassName Solution_2
 * @Author 孙天赐
 * @Date 2025/5/14 8:29
 * @Description TODO: 方法二   贪心算法  1ms  100%
 *                  不需要关注怎么到达的，只需要关注在遇到0的时候，前面的操作能否跳过0即可
 */
class Solution_2 {
    public boolean canJump(int[] nums) {
        // 无法到达的情况：数组中存在元素0，且前面的其他操作都无法超过该0（最多到0）
        // 最后一个元素为0，没有影响
        for (int i = 0; i < nums.length - 1; i++) {
            // 找到元素0，则从该位置开始往前找，能否找到能跳过元素0的位置
            if (nums[i] == 0) {
                int j;
                for (j = i - 1; j >= 0; j--) {
                    // j位置能跳过i位置
                    if (nums[j] > i - j) {
                        break;
                    }
                }
                // 如果j小于0，说明没找到，无法跳过该0
                if (j < 0) {
                    return false;
                }
            }
        }
        // 运行到这，说明要么没有0，要么可以跳过0，那一定可以到最后一个下标
        return true;
    }
}
