package LeetCode.Leet900_999.Leet970_979.Leet977;

import java.util.Arrays;

/**
 * TODO: **方法一**    暴力求解    （6ms）
 * 先求平方，再排序
 */
class Solution_1 {
    public int[] sortedSquares(int[] nums) {
        for (int i = 0; i < nums.length; i++) {
            nums[i] = nums[i] * nums[i];
        }
        Arrays.sort(nums);
        return nums;
    }
}
