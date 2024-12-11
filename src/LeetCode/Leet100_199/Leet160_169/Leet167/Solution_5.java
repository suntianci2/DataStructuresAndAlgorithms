package LeetCode.Leet100_199.Leet160_169.Leet167;

/**
 * TODO: ==**方法五**==    与方法四想法类似，但过程相反    （1ms）
 * 两个指针分别从两端开始，缩小空间，直至找到答案
 */
class Solution_5 {
    public int[] twoSum(int[] numbers, int target) {
        int index1 = 0;
        int index2 = numbers.length - 1;
        while (numbers[index1] + numbers[index2] != target) {
            if (numbers[index1] + numbers[index2] < target) {
                index1++;
            } else {
                index2--;
            }
        }

        return new int[]{index1 + 1, index2 + 1};
    }
}