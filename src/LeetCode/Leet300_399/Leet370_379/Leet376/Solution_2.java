package LeetCode.Leet300_399.Leet370_379.Leet376;

/**
 * @ClassName Solution_2
 * @Author 孙天赐
 * @Date 2025/5/10 16:00
 * @Description TODO: 方法二	贪心	0ms	100%
 *                  局部最优：删除单调坡度上的节点（不包括单调坡度两端的节点），那么这个坡度就可以有两个局部峰值。
 *                  整体最优：整个序列有最多的局部峰值，从而达到最长摆动序列。
 *                  需要额外考虑三种情况：
 *                      1. 情况一：上下坡中有平坡
 *                      2. 情况二：数组首尾两端
 *                      3. 情况三：单调坡中有平坡
 */
class Solution_2 {
    public int wiggleMaxLength(int[] nums) {
        if (nums.length <= 1) {
            return nums.length;
        }
        //当前差值
        int curDiff = 0;
        //上一个差值
        int preDiff = 0;
        int count = 1;
        for (int i = 1; i < nums.length; i++) {
            //得到当前差值
            curDiff = nums[i] - nums[i - 1];
            //如果当前差值和上一个差值为一正一负
            //等于0的情况表示初始时的preDiff
            if ((curDiff > 0 && preDiff <= 0) || (curDiff < 0 && preDiff >= 0)) {
                count++;
                preDiff = curDiff;
            }
        }
        return count;
    }
}
