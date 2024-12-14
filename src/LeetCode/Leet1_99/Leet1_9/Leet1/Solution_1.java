package LeetCode.Leet1_99.Leet1_9.Leet1;

/**
 * TODO:**方法一**：暴力求解（55ms）
 * 两层循环暴力寻找。时间复杂度较高
 */
class Solution_1 {
    public int[] twoSum(int[] nums, int target) {
        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[i] + nums[j] == target) {
                    int[] outcome = new int[2];
                    outcome[0] = i;
                    outcome[1] = j;
                    return outcome;
                }
            }
        }
        return null;
    }
}
