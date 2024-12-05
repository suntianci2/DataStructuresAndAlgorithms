package LeetCode.Leet600_699.Leet680_689.Leet682;

/**
 * TODO:==**方法二	定长数组**==	（1ms）
 * <p>
 * 定长数组通过空间换取时间。与变长数组相比，不再需要花费时间去改变数组长度。
 */
class Solution_2 {
    public int calPoints(String[] operations) {
        // 最后得分长度不会超过operations长度
        int[] score = new int[operations.length];
        int len = 0;
        for (String s : operations) {
            if ("C".equals(s)) {
                //前一次得分无效
                len--;
            } else if ("D".equals(s)) {
                // 本回合新获得的得分是前一次得分的两倍
                score[len] = score[len - 1] * 2;
                len++;

            } else if ("+".equals(s)) {
                // 本回合新获得的得分是前两次得分的总和
                score[len] = score[len - 1] + score[len - 2];
                len++;

            } else {
                // 是数字的情况
                score[len] = Integer.parseInt(s);
                len++;
            }
        }
        int sum = 0;
        for (int i = 0; i < len; i++) {
            sum += score[i];
        }
        return sum;
    }
}
