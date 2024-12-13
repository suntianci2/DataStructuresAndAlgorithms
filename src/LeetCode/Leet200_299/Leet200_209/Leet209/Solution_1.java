package LeetCode.Leet200_299.Leet200_209.Leet209;

/**
 * TODO: ==**方法一**==    滑动窗口（双指针）   （1ms）
 * 暴力求解的方法就不写了，这里只写比较好的方法
 */
class Solution_1 {
    public int minSubArrayLen(int target, int[] nums) {
        // 滑动窗口
        int index1 = 0; // 窗口起始索引
        int index2 = 0; // 窗口结束索引
        int nowValue = nums[index1]; // 当前窗口内的元素和
        int result = 0; // 最佳结果（0表示没有结果）
        while (index2 < nums.length) {
            // 如果当前窗口内的值小于目标值，则结束索引向后移动
            if (nowValue < target) {
                index2++;
                if (index2 == nums.length) {
                    break;
                }
                nowValue += nums[index2];
                // 如果当前窗口内的值大于等于目标值，则记录结果，开始索引向后移动
            } else if (nowValue >= target) {
                if (result == 0 || index2 - index1 + 1 < result) {
                    result = index2 - index1 + 1;
                }
                index1++;
                nowValue -= nums[index1 - 1];
            }

        }
        // 循环结束，表明有一个指针越界了，此时就不存在答案了。
        // 若窗口结束索引越界，表明越界前的窗口内答案小于target，
        // 可是越界前窗口结束索引就已经到达了最后，所以后面就不会存在答案了
        return result;
    }
}
