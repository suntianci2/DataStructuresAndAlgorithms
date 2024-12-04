package LeetCode.Leet200_299.Leet230_239.Leet231;

/**
 * TODO:==**方法一	循环**==	（0ms）
 *
 * 每次循环除以2
 */
class Solution_1 {
    public boolean isPowerOfTwo(int n) {
        // 不可能小于0
        if(n <= 0){
            return false;
        }
        if(n == 1){
            return true;
        }
        // 每次循环除以2，并且判断当前值能否被2整除
        while(n != 2){
            if(n % 2 != 0){
                return false;
            }
            n /= 2;
        }
        // 正常退出循环表明是2的幂
        return true;
    }
}
