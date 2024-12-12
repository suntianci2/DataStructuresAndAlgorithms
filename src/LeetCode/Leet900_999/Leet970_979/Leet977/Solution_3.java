package LeetCode.Leet900_999.Leet970_979.Leet977;

/**
 * TODO: ==**方法三**==    双指针2    （1ms）
 * 与方法二类似
 * 双指针也可以从两边开始，向中间移动，新数组也是从后面开始，每次将较大的数放入新数组。
 * 相比方法二，该方法不需要判断边界情况，更好。
 */
class Solution_3 {
    public int[] sortedSquares(int[] nums) {
        int len = nums.length;
        int[] outcome = new int[len];
        int index1 = 0;
        int index2 = len - 1;
        int newIndex = len - 1;
        // 直到所有元素处理完毕
        while (index1 <= index2) {
            int num1 = nums[index1] * nums[index1];
            int num2 = nums[index2] * nums[index2];
            if (num1 >= num2) {
                outcome[newIndex--] = num1;
                index1++;
            } else {
                outcome[newIndex--] = num2;
                index2--;
            }
        }
        return outcome;
    }
}