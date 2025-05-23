package LeetCode.Leet800_899.Leet860_869.Leet860;

/**
 * @ClassName Solution_1
 * @Author 孙天赐
 * @Date 2025/5/20 12:42
 * @Description TODO: 方法一   模拟（贪心） 1ms  100%
 */
class Solution_1 {
    public boolean lemonadeChange(int[] bills) {
        int fiveNum = 0;  // 手头拥有的5美元的个数
        int tenNum = 0;  // 手头拥有的10美元的个数
        for (int i = 0; i < bills.length; i++) {
            if (bills[i] == 5) {
                // 给的5元
                fiveNum++;
            } else if (bills[i] == 10) {
                // 给的10元
                if (fiveNum == 0) {
                    // 找不开
                    return false;
                }
                tenNum++;
                fiveNum--;
            } else {
                // 给的20元
                if ((tenNum != 0 && fiveNum != 0)) {
                    // 贪心：优先找零一个10元一个5元
                    tenNum--;
                    fiveNum--;
                } else if (fiveNum >= 3) {
                    // 没有10元，再找零三个5元
                    fiveNum -= 3;
                } else {
                    // 找不开
                    return false;
                }
            }
        }
        return true;
    }
}
