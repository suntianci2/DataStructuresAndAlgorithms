package LeetCode.Leet100_199.Leet160_169.Leet167;

/**
 * TODO: **方法一**  暴力求解（超时）
 * 两层循环
 * 缺点：时间复杂度高，无法利用已经排序的特点求解。
 */
class Solution_1 {
    public int[] twoSum(int[] numbers, int target) {
        for (int i = 0; i < numbers.length; i++) {
            for (int j = i + 1; j < numbers.length; j++) {
                if (numbers[i] + numbers[j] == target) {
                    return new int[]{i + 1, j + 1};
                }
            }
        }
        return new int[]{-1, -1};
    }
}
