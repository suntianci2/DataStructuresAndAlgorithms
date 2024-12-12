package LeetCode.Leet900_999.Leet970_979.Leet977;

/**
 * TODO: ==**方法二**==    双指针 （1ms）
 * 先找到非负数开始的位置，然后从该位置和前一个位置（前后指针）开始，判断指针处元素值大小，放入新数组。
 * 前指针向前移动，后指针向后移动
 *
 */
class Solution_2 {
    public int[] sortedSquares(int[] nums) {
        if (nums.length == 1) {
            return new int[]{nums[0] * nums[0]};
        }
        int[] outcome = new int[nums.length];
        int startIndex = 0;
        // 找到非负数开始的位置，若全为负数，则找到最后一个位置
        while (startIndex < nums.length - 1 && nums[startIndex] < 0) {
            startIndex++;
        }

        // 从非负数的位置开始，双指针分别前后移动，将更小的值放入新数组中，直到一个指针到边界
        int index1 = startIndex - 1;  // 前指针
        int index2 = startIndex;  // 后指针
        int newIndex = 0;
        while (index1 >= 0 && index2 < nums.length) {
            int num1 = nums[index1] * nums[index1];
            int num2 = nums[index2] * nums[index2];
            if (num1 <= num2) {
                outcome[newIndex++] = num1;
                index1--;
            } else {
                outcome[newIndex++] = num2;
                index2++;
            }
        }

        // 当循环退出时，表明有一个指针到边界了，把另一边的数添加到数组中
        // 左指针到边界
        if (index1 < 0) {
            while (index2 < nums.length) {
                outcome[newIndex++] = nums[index2] * nums[index2];
                index2++;
            }
        }
        // 右指针到边界
        if (index2 >= nums.length) {
            while (index1 >= 0) {
                outcome[newIndex++] = nums[index1] * nums[index1];
                index1--;
            }
        }
        return outcome;
    }
}
