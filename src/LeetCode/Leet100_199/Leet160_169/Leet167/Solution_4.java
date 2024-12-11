package LeetCode.Leet100_199.Leet160_169.Leet167;

/**
 * TODO: ==**方法四**== 滑动窗口（双指针）
 * 首先，两个指针从第一个和第二个位置开始，接下来进入循环：判断两个指针出的元素和是否小于target，如果小于，则两个指针各向后移动一位。
 * 当退出循环了，表明当前两个指针出的元素和大于等于了target。
 * 这时候，如果两个指针的元素和等于target表明答案就是这两个元素。
 * 如果两个指针元素和大于target，则说明两个指针处在**答案所围成的窗口**中。
 * 接下来进入循环，每次循环执行以下操作，直到两个元素和等于target：
 * 1. 若元素和大于target，则前面一个指针向前移动一位。
 * 2. 若元素和小于target，则后面一个指针向前移动一位。
 * 当退出循环时，两个指针处即为答案。
 */
class Solution_4 {
    public int[] twoSum(int[] numbers, int target) {
        int index1 = 0;
        int index2 = 1;
        // 移动到第一步的指定位置
        while (numbers[index1] + numbers[index2] < target) {
            index1++;
            index2++;
        }

        // 从该位置开始，向外扩散两个指针，直到找到答案。
        while (numbers[index1] + numbers[index2] != target) {
            if (numbers[index1] + numbers[index2] < target) {
                index2++;
            } else {
                index1--;
            }
        }
        return new int[]{index1 + 1, index2 + 1};
    }
}
