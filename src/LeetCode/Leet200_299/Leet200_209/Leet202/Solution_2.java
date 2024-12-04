package LeetCode.Leet200_299.Leet200_209.Leet202;

/**
 * TODO:**方法二	巨大的数组**（1ms）
 * <p>
 * 使用一个足够大的数组记录出现过的数。
 */
class Solution_2 {
    public boolean isHappy(int n) {
        // 经计算，无论第一个值有多大，经过一次运算后，其大小都不会超过800
        int[] arr = new int[800];
        while (n != 1) {
            // 计算每个位置上的数字的平方和。
            int newN = 0;
            while (n != 0) {
                newN += Math.pow(n % 10, 2);
                n /= 10;
            }
            n = newN;
            // 判断新的数与之前出现过的数是否有重复
            if (arr[n] == 0) {
                arr[n] = 1;
            } else {
                return false;
            }
        }
        return true;
    }
}
