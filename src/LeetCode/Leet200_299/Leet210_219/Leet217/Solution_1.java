package LeetCode.Leet200_299.Leet210_219.Leet217;

import java.util.Arrays;

/**
 * TODO:**方法一	排序**	（19ms）
 * <p>
 * 先排序再遍历比较
 */
class Solution_1 {
    public boolean containsDuplicate(int[] nums) {
        Arrays.sort(nums);
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] == nums[i - 1]) {
                return true;
            }
        }
        return false;
    }
}
