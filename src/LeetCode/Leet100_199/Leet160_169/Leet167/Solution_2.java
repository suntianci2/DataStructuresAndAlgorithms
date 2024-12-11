package LeetCode.Leet100_199.Leet160_169.Leet167;

/**
 * TODO: **方法二** 暴力求解优化  （4ms）
 * 利用已经排序的特点，在内层循环中可以使用二分查找减少时间复杂度
 */
class Solution_2 {
    public int[] twoSum(int[] numbers, int target) {
        if (numbers.length == 2) {
            return new int[]{0, 1};
        }
        for (int i = 0; i < numbers.length; i++) {
            int x1 = i;
            int x2 = numbers.length;
            // 当x2和x1相邻，说明没有目标值，则退出循环
            while (x2 - x1 > 1) {
                int mediumIndex = (x1 + x2) / 2;
                if (numbers[mediumIndex] + numbers[i] == target) {
                    // 找到答案
                    int[] outcome = new int[2];
                    outcome[0] = i + 1;
                    outcome[1] = mediumIndex + 1;
                    return outcome;
                } else if (numbers[mediumIndex] + numbers[i] < target) {
                    // 目标值可能在medium右侧
                    // 调整左侧边界
                    x1 = mediumIndex;
                } else {
                    // 目标值可能在medium左侧
                    // 调整右侧边界
                    x2 = mediumIndex;
                }
            }
        }
        return new int[]{-1, -1};
    }
}
