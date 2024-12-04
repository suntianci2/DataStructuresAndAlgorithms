package LeetCode.Leet300_399.Leet320_329.Leet326;

/**
 * TODO:==**方法一	递归**==	（8ms）
 */
class Solution_1 {
    public boolean isPowerOfThree(int n) {
        if(n == 1){
            return true;
        }
        if(n % 3 == 0 && n != 0){
            return isPowerOfThree(n / 3);
        }

        return false;
    }
}
