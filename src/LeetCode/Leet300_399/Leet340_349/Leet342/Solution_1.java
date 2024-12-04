package LeetCode.Leet300_399.Leet340_349.Leet342;

/**
 * TODO:==**方法一	循环**==	（0ms）
 *
 * 每次循环除以4
 */
class Solution_1 {
    public boolean isPowerOfFour(int n) {
        // 不可能小于0
        if(n <= 0){
            return false;
        }
        // 每次循环除以4，并且判断当前值能否被4整除
        while(n >= 4){
            if(n % 4 != 0){
                return false;
            }
            n /= 4;
        }
        // 只有最后为1才满足条件
        return n == 1;
    }
}
