package LeetCode.Leet600_699.Leet670_679.Leet674;

/**
 * TODO:==**方法一	双指针**==	（1ms）
 * <p>
 * 两个指针同时从数组前面开始。注意循环结束要判断一下最后面的子序列是否为最长序列
 */
class Solution_1 {
    public int findLengthOfLCIS(int[] nums) {
        int len = 0;
        if (nums.length == 1) {
            return 1;
        }
        int first = 0;
        int second = 1;
        while (second < nums.length) {
            if (nums[second - 1] >= nums[second]) {
                if (second - first > len) {
                    len = second - first;
                }
                first = second;
            }
            second++;
        }
        len = (second - first) > len ? (second - first) : len;
        return len;
    }
}
