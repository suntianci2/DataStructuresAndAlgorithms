package LeetCode.Leet1_99.Leet50_59.Leet55;

/**
 * @ClassName Solution_3
 * @Author 孙天赐
 * @Date 2025/5/14 9:07
 * @Description TODO: 方法三   贪心算法  2ms  83.62%
 *                  维护一个从当前位置可以走到的最远距离，当为0时，则说明无法到达（已经到达最后一个下标除外）
 */
class Solution_3 {
    public boolean canJump(int[] nums) {
        // 维护一个从当前位置可以走到的最远距离，当为0时，则说明无法到达（已经到达最后一个下标除外）
        int max = nums[0];
        for(int i = 0;i < nums.length;i++){
            // 更新从i位置开始最大可走的距离
            max = Math.max(nums[i], max - 1);
            // 距离小于为0，则说明无法到达最后一个下标（已经到达最后一个下标除外）
            if(max <= 0 && i != nums.length - 1){
                return false;
            }
        }
        // 循环结束后，则已到达最后一个下标
        return true;
    }
}