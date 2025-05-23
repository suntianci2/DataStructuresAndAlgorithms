package LeetCode.Leet300_399.Leet360_369.Leet367;

/**
 * @ClassName Solution_1
 * @Author 孙天赐
 * @Date 2025/5/10 17:06
 * @Description TODO: 方法一   二分查找   0ms  100%
 */
class Solution {
    public boolean isPerfectSquare(int num) {
        if (num == 1) {
            return true;
        }
        // 计算平方根的整数部分（忽略小数）
        // 在(0, num)中寻找平方根的整数部分（num为1不成立）
        int left = 0;
        int right = num;
        int sqrt = 0;
        while (left < right - 1) {
            int middle = (left + right) / 2;
            // 不能用middle * middle < num，可能middle * middle会越界，两边各除以middle即可
            if (middle < num / middle) {
                left = middle;
            } else if (middle > num / middle) {
                right = middle;
            } else {
                if (middle * middle == num) {
                    // 找到了真正的整数平方根
                    return true;
                } else if (middle * middle < num) {
                    // 找到的平方根更小，则缩小左边界
                    left = middle;
                } else {
                    // 找到的平方根更大，则缩小左边界
                    right = middle;
                }
            }
        }
        // 当两指针相遇还没找到，那就是没有
        return false;
    }
}
