package LeetCode.Leet1_99.Leet50_59.Leet55;

/**
 * @ClassName Solution_4
 * @Author 孙天赐
 * @Date 2025/5/14 9:27
 * @Description TODO: 方法四   贪心算法（优化）  1ms  100%
 *                  对方法三的优化，在覆盖范围内更新最大的覆盖范围
 */
class Solution_4 {
    public boolean canJump(int[] nums) {
        if (nums.length == 1) {
            return true;
        }
        // 覆盖范围, 初始覆盖范围应该是0，因为下面的迭代是从下标0开始的
        int coverRange = 0;
        // 在覆盖范围内更新最大的覆盖范围
        for (int i = 0; i <= coverRange; i++) {
            coverRange = Math.max(coverRange, i + nums[i]);
            if (coverRange >= nums.length - 1) {
                return true;
            }
        }
        return false;
    }
}
