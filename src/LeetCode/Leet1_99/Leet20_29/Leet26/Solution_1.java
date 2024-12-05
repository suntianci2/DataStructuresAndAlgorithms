package LeetCode.Leet1_99.Leet20_29.Leet26;

/**
 * TODO:==**方法一	双指针**==	（0ms）
 */
class Solution_1 {
    public int removeDuplicates(int[] nums) {
        int first = 0;
        int second = 1;
        // 忽略相同元素，将不同元素提前
        while (second < nums.length) {
            if (nums[first] != nums[second]) {
                nums[first + 1] = nums[second];
                first++;
            }
            second++;
        }
        return first + 1;
    }
}
