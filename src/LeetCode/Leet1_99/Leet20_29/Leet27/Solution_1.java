package LeetCode.Leet1_99.Leet20_29.Leet27;

/**
 * TODO:**方法一	双指针**	（0ms）
 * <p>
 * 两个指针都从头部开始
 */
class Solution_1 {
    public int removeElement(int[] nums, int val) {
        // 特殊情况判断
        if (nums.length == 0) {
            return 0;
        }
        if (nums.length == 1) {
            if (nums[0] == val) {
                return 0;
            } else {
                return 1;
            }
        }
        // 双指针
        int first = 0;
        // 从不满足条件的位置开始
        while (first < nums.length && nums[first] != val) {
            first++;
        }
        int second = first + 1;
        // 将满足的值放到前面
        while (second < nums.length) {
            if (nums[second] != val) {
                nums[first] = nums[second];
                first++;
            }
            second++;
        }
        return first;
    }
}
