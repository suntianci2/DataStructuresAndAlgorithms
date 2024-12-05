package LeetCode.Leet1_99.Leet20_29.Leet27;

/**
 * ==**方法二	双指针优化**	（0ms）==
 * <p>
 * 一个指针从前面开始，另一个指针从尾部开始
 */
class Solution_2 {
    public int removeElement(int[] nums, int val) {
        int left = 0;
        int right = nums.length - 1;
        while (left <= right) {
            if (nums[left] == val) {
                // 如果左侧元素是要删除的元素，把右侧元素放到左侧
                nums[left] = nums[right];
                right--;
            } else {
                // 如果左侧元素不是是要删除的元素，跳过该元素
                left++;
            }
        }
        // left值即为元素
        return left;
    }
}
