package LeetCode.Leet1_99.Leet50_59.Leet55;

/**
 * @ClassName Solution_1
 * @Author 孙天赐
 * @Date 2025/5/14 8:28
 * @Description TODO: 方法一   递归回溯  超时
 */
class Solution_1 {
    public boolean canJump(int[] nums) {
        return doJump(nums, 0);
    }

    public boolean doJump(int[] nums, int startIndex) {
        if (startIndex == nums.length - 1) {
            return true;
        }

        // 从当前位置开始，跳i步，然后递归回溯
        // 尽可能往多了跳
        for (int i = nums[startIndex]; i >= 1; i--) {
            if (doJump(nums, startIndex + i)) {
                return true;
            }
        }

        // 能运行到这，说明不能达到最后一个下标
        return false;
    }
}
